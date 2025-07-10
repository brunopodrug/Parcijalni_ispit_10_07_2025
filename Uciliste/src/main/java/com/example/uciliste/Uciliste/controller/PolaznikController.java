package com.example.uciliste.Uciliste.controller;

import com.example.uciliste.Uciliste.dto.PolaznikDto;
import com.example.uciliste.Uciliste.service.PolaznikService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/polaznici")
@RestController
public class PolaznikController {

    PolaznikService polaznikService;

    public PolaznikController(PolaznikService polaznikService) {
        this.polaznikService = polaznikService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PolaznikDto save(@RequestBody final PolaznikDto command) {
        return polaznikService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Greska prilikom " +
                        "dodavanja novog polaznika."));
    }

    @GetMapping
    public List<PolaznikDto> getAllPolaznici() {
        List<PolaznikDto> polaznici = polaznikService.getAllPolaznik();
        return polaznici;
    }

    @GetMapping("/{id}")
    public PolaznikDto getById(@PathVariable("id") Long polaznikId) {
        return polaznikService.findById(polaznikId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji polaznik sa ID-om:" + polaznikId));
    }

    @PutMapping("/{id}")
    public PolaznikDto update(@PathVariable("id") Long polaznikId,@RequestBody final PolaznikDto polaznikDto) {
        return polaznikService.updatePolaznik(polaznikId, polaznikDto)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji polaznik sa ID-om:" + polaznikId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long polaznikId) {
        polaznikService.deletePolaznik(polaznikId);
    }
}
