package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.AuthRequestDTO;
import com.example.uciliste.Uciliste.dto.JwtResponseDTO;
import com.example.uciliste.Uciliste.dto.PolaznikDto;
import com.example.uciliste.Uciliste.repository.SpringDataPolaznikRepository;
import com.example.uciliste.Uciliste.service.PolaznikService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PolaznikControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SpringDataPolaznikRepository polaznikRepository;

    @Autowired
    private PolaznikService polaznikService;

    @Autowired
    private AuthController authController;

    private String accessToken;

    private PolaznikDto polaznikDTO;

    @BeforeEach
    void setUp() throws Exception {
        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setUsername("admin");
        authRequest.setPassword("admin");

        JwtResponseDTO jwtResponse = authController.authenticateAndGetToken(authRequest);
        accessToken = jwtResponse.getAccessToken();

        polaznikDTO = new PolaznikDto();
        polaznikDTO.setIme("Duje");
        polaznikDTO.setPrezime("Dujic");
    }

    @Test
    void testGetAllPolaznici() throws Exception {
        polaznikService.save(polaznikDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/polaznici")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].ime", is("Ante")))
                .andExpect(jsonPath("$[0].prezime", is("Antic")));
    }

    @Test
    void testGetPolaznikById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/polaznici/{id}", 2L)
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ime", is("Ivo")))
                .andExpect(jsonPath("$.prezime", is("Ivic")));
    }

    @Test
    void testSaveNewPolaznik() throws Exception {
        mockMvc.perform(post("/polaznici")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(polaznikDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.ime", is("Duje")))
                .andExpect(jsonPath("$.prezime", is("Dujic")));
    }

    @Test
    void testUpdatePolaznik() throws Exception {
        polaznikService.save(polaznikDTO);

        polaznikDTO.setIme("Updated Ime");

        mockMvc.perform(put("/polaznici/{id}", 4L)
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(polaznikDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ime", is("Updated Ime")));
    }
}
