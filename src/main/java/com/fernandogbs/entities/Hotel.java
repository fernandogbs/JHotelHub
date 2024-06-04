package com.fernandogbs.entities;

import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Hospede> hospedes;
    private List<Reserva> reservas;

    public Hotel(List<Quarto> quartos, List<Reserva> reservas) {
        this.quartos = quartos;
        this.reservas = reservas;
        gerarRelatorio();
    }

    public void adicionarQuarto(int numero, String tipo){
        quartos.add(new Quarto(numero, tipo));
    }

    public boolean criarReserva(Hospede hospede, int numero, LocalDate checkIn, , LocalDate checkOut){}

}
