package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.PolaznikDto;
import com.example.uciliste.Uciliste.service.PolaznikService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PolaznikControllerTest {
    @Mock
    private PolaznikService polaznikService;

    @InjectMocks
    private PolaznikController polaznikController;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<PolaznikDto> polaznici;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(polaznikController).build();

        // Initialize mock data
        PolaznikDto polaznik1 = new PolaznikDto("Toma", "Tomic", "backend java");
        PolaznikDto polaznik2 = new PolaznikDto("Ivana", "Ivancic", "frontend");
        polaznici = Arrays.asList(polaznik1, polaznik2);
    }

    @Test
    void testGetAllPolaznici() throws Exception {
        when(polaznikService.getAllPolaznik()).thenReturn(polaznici);

        List<PolaznikDto> result = polaznikController.getAllPolaznici();

        assertEquals(2, result.size());
        verify(polaznikService, times(1)).getAllPolaznik();
    }

    @Test
    void testGetPolaznikById() throws Exception {
        Long polaznikId = 1L;
        PolaznikDto poalznikDto = new PolaznikDto("Bruno", "Podrug" , "c++");
        when(polaznikService.findById(polaznikId)).thenReturn(Optional.of(poalznikDto));

        PolaznikDto result = polaznikController.getById(polaznikId);

        assertEquals(poalznikDto, result);
        verify(polaznikService, times(1)).findById(polaznikId);
    }

    @Test
    void testSaveNewPolaznik() throws Exception {
        PolaznikDto poalznikDto = new PolaznikDto("Bruno", "Podrug", "c++");
        when(polaznikService.save(poalznikDto)).thenReturn(Optional.of(poalznikDto));

        PolaznikDto result = polaznikController.save(poalznikDto);

        assertEquals(poalznikDto, result);
        verify(polaznikService, times(1)).save(poalznikDto);
    }

    @Test
    void testUpdatePolaznik() {
        Long polaznikId = 2L;
        PolaznikDto polaznikDto = new PolaznikDto("Sime", "Simic", "backend java");
        when(polaznikService.updatePolaznik(polaznikId, polaznikDto)).thenReturn(Optional.of(polaznikDto));

        PolaznikDto result = polaznikController.update(polaznikId, polaznikDto);

        assertEquals(polaznikDto, result);
        verify(polaznikService, times(1)).updatePolaznik(polaznikId, polaznikDto);
    }

    @Test
    void testDeletePolaznik() {
        Long polaznikId = 1L;
        doNothing().when(polaznikService).deletePolaznik(polaznikId);

        polaznikController.delete(polaznikId);

        verify(polaznikService, times(1)).deletePolaznik(polaznikId);
    }
}
