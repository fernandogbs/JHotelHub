package com.fernandogbs.entities;

import java.io.Serializable;
import java.time.LocalDate;


public class Reserva implements Serializable {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

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

