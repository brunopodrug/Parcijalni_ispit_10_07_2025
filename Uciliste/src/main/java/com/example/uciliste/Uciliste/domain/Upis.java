package com.example.uciliste.Uciliste.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upisId;

    @ManyToOne
    @JoinColumn(name = "IDProgramObrazovanja", referencedColumnName = "programObrazovanjaId")
    private ProgramObrazovanja programObrazovanja;

    @ManyToOne
    @JoinColumn(name = "IDPolaznik", referencedColumnName = "polaznikId")
    private Polaznik polaznik;

    public Long getUpisId() {
        return upisId;
    }

    public void setUpisId(Long upisId) {
        this.upisId = upisId;
    }

    public ProgramObrazovanja getProgramObrazovanja() {
        return programObrazovanja;
    }

    public void setProgramObrazovanja(ProgramObrazovanja programObrazovanja) {
        this.programObrazovanja = programObrazovanja;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }
}
