package com.example.uciliste.Uciliste.service;

import com.example.uciliste.Uciliste.dto.ProgramObrazovanjaDto;
import com.example.uciliste.Uciliste.repository.SpringDataProgramObrazovanjaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{

    SpringDataProgramObrazovanjaRepository springDataProgramObrazovanjaRepository;
    ModelMapper modelMapper;

    public ProgramObrazovanjaServiceImpl(SpringDataProgramObrazovanjaRepository springDataProgramObrazovanjaRepository, ModelMapper modelMapper) {
        this.springDataProgramObrazovanjaRepository = springDataProgramObrazovanjaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProgramObrazovanjaDto> getAllPorgramObrazovanja() {
        return springDataProgramObrazovanjaRepository.findAll().stream()
                .map(program -> modelMapper.map(program, ProgramObrazovanjaDto.class))
                .collect(Collectors.toList());
    }
}
