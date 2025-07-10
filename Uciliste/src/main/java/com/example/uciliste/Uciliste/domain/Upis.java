package com.example.uciliste.Uciliste.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @Override
    public String toString() {
        return "Upis{" +
                "id=" + upisId +
                ", polaznikId=" + (polaznik != null ? polaznik.getPolaznikId() : null) +
                ", programObrazovanjaId=" + (programObrazovanja != null ? programObrazovanja.getProgramObrazovanjaId() : null) +
                '}';
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
