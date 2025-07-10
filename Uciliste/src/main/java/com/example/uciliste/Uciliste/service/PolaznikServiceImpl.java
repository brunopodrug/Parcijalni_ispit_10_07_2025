package com.example.uciliste.Uciliste.service;

import com.example.uciliste.Uciliste.domain.Polaznik;
import com.example.uciliste.Uciliste.domain.Upis;
import com.example.uciliste.Uciliste.dto.PolaznikDto;
import com.example.uciliste.Uciliste.mapper.PolaznikMapper;
import com.example.uciliste.Uciliste.repository.SpringDataPolaznikRepository;
import com.example.uciliste.Uciliste.repository.SpringDataUpisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolaznikServiceImpl implements PolaznikService {

    SpringDataPolaznikRepository polaznikRepository;
    ModelMapper modelMapper;
    PolaznikMapper polaznikMapper;
    SpringDataUpisRepository springDataUpisRepository;

    public PolaznikServiceImpl(SpringDataPolaznikRepository polaznikRepository, ModelMapper modelMapper,
                               PolaznikMapper polaznikMapper, SpringDataUpisRepository springDataUpisRepository) {
        this.polaznikRepository = polaznikRepository;
        this.modelMapper = modelMapper;
        this.polaznikMapper = polaznikMapper;
        this.springDataUpisRepository = springDataUpisRepository;
    }

    @Override
    public Optional<PolaznikDto> save(PolaznikDto polaznikDto) {
        Polaznik polaznik = modelMapper.map(polaznikDto, Polaznik.class);
        Polaznik savedPolaznik = polaznikRepository.save(polaznik);

        return Optional.of(modelMapper.map(savedPolaznik, PolaznikDto.class));
    }

    @Override
    public List<PolaznikDto> getAllPolaznik() {
        List<Polaznik> polaznici = polaznikRepository.findAll();
        return polaznici.stream().map(polaznik -> polaznikMapper.mapToPolaznikDto(polaznik)).collect(Collectors.toList());
    }

    @Override
    public Optional<PolaznikDto> findById(Long polaznikID) {
        Polaznik polaznik = polaznikRepository.findById(polaznikID).orElseThrow();
        return Optional.of(polaznikMapper.mapToPolaznikDto(polaznik));
    }

    @Override
    public Optional<PolaznikDto> updatePolaznik(Long polaznikId, PolaznikDto polaznikDto) {
        Optional<Polaznik> polaznik = polaznikRepository.findById(polaznikId);

        if (polaznik.isPresent()) {
            Polaznik polaznikToUpdate = polaznik.get();
            polaznikToUpdate.setIme(polaznikDto.getIme());
            polaznikToUpdate.setPrezime(polaznikDto.getPrezime());
            polaznikToUpdate.setProgramNaziv(polaznikDto.getProgramNaziv());

            Polaznik updatedPolaznik = polaznikRepository.save(polaznikToUpdate);
            return Optional.of(polaznikMapper.mapToPolaznikDto(updatedPolaznik));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deletePolaznik(Long polaznikId) {
        Optional<Polaznik> polaznik = polaznikRepository.findById(polaznikId);
        polaznik.ifPresent(polaznikRepository::delete);
    }
}
