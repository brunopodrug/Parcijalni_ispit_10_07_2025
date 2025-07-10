package com.example.uciliste.Uciliste.dto;

public class PolaznikDto {
    private String ime;

    private String prezime;

    private String programNaziv;

    public String getProgramNaziv() {
        return programNaziv;
    }

    public void setProgramNaziv(String programNaziv) {
        this.programNaziv = programNaziv;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public PolaznikDto(String ime, String prezime, String programNaziv) {
        this.ime = ime;
        this.prezime = prezime;
        this.programNaziv = programNaziv;
    }

    public PolaznikDto() {
    }
}
