package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.UpisDto;
import com.example.uciliste.Uciliste.service.UpisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/upisi")
@RestController
public class UpisController {
    UpisService upisService;

    public UpisController(UpisService upisService) {
        this.upisService = upisService;
    }

    @GetMapping
    public List<UpisDto> getAllUpisi() {
        List<UpisDto> upisi = upisService.getAllUpisi();
        return upisi;
    }
}
