package com.fernandogbs.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
   private Hospede hospede;
   private Quarto quarto;
   private LocalDate checkIn;
   private LocalTime checkOut;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate checkIn, LocalTime checkOut) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getCheckin() {
        return checkIn;
    }

    public void setCheckin(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckout() {
        return checkOut;
    }

    public void setCheckout(LocalTime checkOut) {
        this.checkOut = checkOut;
    }
}
