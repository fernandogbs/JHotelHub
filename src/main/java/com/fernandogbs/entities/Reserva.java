package com.fernandogbs.entities;

import java.io.Serializable;
import java.time.LocalDate;


public class Reserva implements Serializable {
    //variaveis constantes
    private final Hospede hospede;
    private final Quarto quarto;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    //construtor
    public Reserva(Hospede hospede, Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //getters e setters
    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    //impressão de informações da Reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "hospede=" + hospede +
                ", quarto=" + quarto +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}

