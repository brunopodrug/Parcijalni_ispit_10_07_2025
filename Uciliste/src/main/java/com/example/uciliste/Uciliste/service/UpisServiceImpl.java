package com.example.uciliste.Uciliste.service;

import com.example.uciliste.Uciliste.domain.Polaznik;
import com.example.uciliste.Uciliste.domain.Upis;
import com.example.uciliste.Uciliste.dto.UpisDto;
import com.example.uciliste.Uciliste.repository.SpringDataUpisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UpisServiceImpl implements UpisService {
    SpringDataUpisRepository springDataUpisRepository;
    ModelMapper modelMapper;

    public UpisServiceImpl(SpringDataUpisRepository springDataUpisRepository, ModelMapper modelMapper) {
        this.springDataUpisRepository = springDataUpisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UpisDto> getAllUpisi() {
        return springDataUpisRepository.findAll().stream()
                .map(upis -> modelMapper.map(upis, UpisDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUpis(Long upisId) {
        Optional<Upis> upis = springDataUpisRepository.findById(upisId);
        upis.ifPresent(springDataUpisRepository::delete);
    }
}
