package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.ProgramObrazovanjaDto;
import com.example.uciliste.Uciliste.service.ProgramObrazovanjaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/program-obrazovanja")
@RestController
public class ProgramObrazovanjaController {
    ProgramObrazovanjaService programObrazovanjaService;

    public ProgramObrazovanjaController(ProgramObrazovanjaService programObrazovanjaService) {
        this.programObrazovanjaService = programObrazovanjaService;
    }

    @GetMapping
    public List<ProgramObrazovanjaDto> getAllPolaznici() {
        List<ProgramObrazovanjaDto> programObrazovanjaList = programObrazovanjaService.getAllPorgramObrazovanja();
        return programObrazovanjaList;
    }
}
