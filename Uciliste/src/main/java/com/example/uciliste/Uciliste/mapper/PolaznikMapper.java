package com.example.uciliste.Uciliste.mapper;

import com.example.uciliste.Uciliste.domain.Polaznik;
import com.example.uciliste.Uciliste.dto.PolaznikDto;

public interface PolaznikMapper {
    public PolaznikDto mapToPolaznikDto(Polaznik polaznik);
}
