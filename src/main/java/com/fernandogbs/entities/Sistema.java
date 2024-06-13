package com.fernandogbs.entities;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.*;

public class Sistema {
//   contém listas de hóspedes, quartos, reservas e um mapa de reservas por hóspede.
//   é responsável por gerenciar todas as operações do sistema de reservas do hotel
    private List<Hospede> hospedes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private Map<String, List<Reserva>> reservasPorHospede;


    //O construtor inicializa as listas e o mapa, e carrega os dados salvos de um arquivo.
    public Sistema() {
        hospedes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        reservasPorHospede = new HashMap<>();
        carregarDados();
    }


    /* metodos publicos */

    //Adiciona um novo hóspede à lista e salva os dados.
    public void adicionarHospede(String nome, String telefone, String email) {
        Hospede hospede = new Hospede(nome, telefone, email);
        hospedes.add(hospede);
        salvarDados();
    }

    //Adiciona um novo quarto à lista e salva os dados.
    public void adicionarQuarto(int numero, String tipo, double preco) {
        Quarto quarto = new Quarto(numero, tipo, preco);
        quartos.add(quarto);
        salvarDados();
    }

    //Cria uma nova reserva para um hóspede específico em um quarto específico, se ambos existirem, e salva os dados.
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

    //Consulta e imprime todas as reservas de um hóspede específico.
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

    //Consulta e imprime todas as reservas que incluem uma data específica.
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

    //Cancela uma reserva específica de um hóspede com base na data de check-in.
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

    /* metodos privados */

    //Busca um hóspede pelo nome.
    private Hospede buscarHospede(String nome) {
        for (Hospede hospede : hospedes) {
            if (hospede.getNome().equals(nome)) {
                return hospede;
            }
        }
        return null;
    }

    //Busca um quarto pelo número.
    private Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    //Salva os dados em um arquivo chamado dados.dat.
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

    //Carrega os dados de um arquivo chamado dados.dat.
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
