package com.example.uciliste.Uciliste.mapper;

import com.example.uciliste.Uciliste.domain.Polaznik;
import com.example.uciliste.Uciliste.dto.PolaznikDto;
import org.springframework.stereotype.Component;

@Component
public class PolaznikMapperImpl implements PolaznikMapper {

    @Override
    public PolaznikDto mapToPolaznikDto(Polaznik polaznik) {
        return new PolaznikDto (
                polaznik.getIme(),
                polaznik.getPrezime(),
                polaznik.getProgramNaziv()
        );


    }
}
