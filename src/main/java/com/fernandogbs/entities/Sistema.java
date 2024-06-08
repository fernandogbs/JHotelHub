package com.fernandogbs.entities;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.*;

public class Sistema {
    private List<Hospede> hospedes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private Map<String, List<Reserva>> reservasPorHospede;

    public Sistema() {
        hospedes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        reservasPorHospede = new HashMap<>();
        carregarDados();
    }

    public void adicionarHospede(String nome, String telefone, String email) {
        Hospede hospede = new Hospede(nome, telefone, email);
        hospedes.add(hospede);
        salvarDados();
    }

    public void adicionarQuarto(int numero, String tipo, double preco) {
        Quarto quarto = new Quarto(numero, tipo, preco);
        quartos.add(quarto);
        salvarDados();
    }

    public void criarReserva(String nomeHospede, int numeroQuarto, LocalDate checkIn, LocalDate checkOut) {
        Hospede hospede = buscarHospede(nomeHospede);
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (hospede != null && quarto != null) {
            Reserva reserva = new Reserva(hospede, quarto, checkIn, checkOut);
            reservas.add(reserva);
            reservasPorHospede.computeIfAbsent(nomeHospede, k -> new ArrayList<>()).add(reserva);
            System.out.println("Reserva criada com sucesso!");
            salvarDados();
        } else {
            System.out.println("Hóspede ou quarto não encontrado.");
        }
    }

    public void consultarReservasPorHospede(String nomeHospede) {
        List<Reserva> reservasHospede = reservasPorHospede.getOrDefault(nomeHospede, new ArrayList<>());
        if (reservasHospede.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hóspede " + nomeHospede);
        } else {
            for (Reserva reserva : reservasHospede) {
                System.out.println(reserva);
            }
        }
    }

    public void consultarReservasPorData(LocalDate data) {
        List<Reserva> reservasData = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if ((reserva.getCheckIn().isBefore(data) || reserva.getCheckIn().isEqual(data)) &&
                    (reserva.getCheckOut().isAfter(data) || reserva.getCheckOut().isEqual(data))) {
                reservasData.add(reserva);
            }
        }
        if (reservasData.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para a data " + data);
        } else {
            for (Reserva reserva : reservasData) {
                System.out.println(reserva);
            }
        }
    }

    public void cancelarReserva(String nomeHospede, LocalDate checkIn) {
        List<Reserva> reservasHospede = reservasPorHospede.get(nomeHospede);
        if (reservasHospede != null) {
            for (Reserva reserva : reservasHospede) {
                if (reserva.getCheckIn().isEqual(checkIn)) {
                    reservas.remove(reserva);
                    reservasHospede.remove(reserva);
                    System.out.println("Reserva cancelada com sucesso!");
                    salvarDados();
                    return;
                }
            }
        }
        System.out.println("Reserva não encontrada para o hóspede " + nomeHospede + " na data " + checkIn);
    }

    private Hospede buscarHospede(String nome) {
        for (Hospede hospede : hospedes) {
            if (hospede.getNome().equals(nome)) {
                return hospede;
            }
        }
        return null;
    }

    private Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.dat"))) {
            oos.writeObject(hospedes);
            oos.writeObject(quartos);
            oos.writeObject(reservas);
            oos.writeObject(reservasPorHospede);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.dat"))) {
            hospedes = (List<Hospede>) ois.readObject();
            quartos = (List<Quarto>) ois.readObject();
            reservas = (List<Reserva>) ois.readObject();
            reservasPorHospede = (Map<String, List<Reserva>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
