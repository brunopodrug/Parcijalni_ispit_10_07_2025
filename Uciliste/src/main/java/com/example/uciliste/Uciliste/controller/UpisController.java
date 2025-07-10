package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.UpisDto;
import com.example.uciliste.Uciliste.service.UpisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long upisId) {
        upisService.deleteUpis(upisId);
    }
}
