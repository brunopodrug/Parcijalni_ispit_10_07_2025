package com.example.uciliste.Uciliste.dto;

public class PolaznikDto {
    private String ime;

    private String prezime;

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

    public PolaznikDto(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public PolaznikDto() {
    }
}
