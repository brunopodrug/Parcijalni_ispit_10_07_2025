package com.example.uciliste.Uciliste.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProgramObrazovanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programObrazovanjaId;

    private String naziv;

    private int csvet;

    @OneToMany(mappedBy = "programObrazovanja", cascade = CascadeType.ALL)
    private Set<Upis> upisSetprogramObraz = new HashSet<>();

    @Override
    public String toString() {
        return "ProgramObrazovanja{" +
                "id=" + programObrazovanjaId +
                ", naziv='" + naziv + '\'' +
                '}';
    }

    public Long getProgramObrazovanjaId() {
        return programObrazovanjaId;
    }

    public void setProgramObrazovanjaId(Long programObrazovanjaId) {
        this.programObrazovanjaId = programObrazovanjaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCsvet() {
        return csvet;
    }

    public void setCsvet(int csvet) {
        this.csvet = csvet;
    }

    public Set<Upis> getUpisSetprogramObraz() {
        return upisSetprogramObraz;
    }

    public void setUpisSetprogramObraz(Set<Upis> upisSetprogramObraz) {
        this.upisSetprogramObraz = upisSetprogramObraz;
    }
}
