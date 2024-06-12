package com.fernandogbs.application;


import com.fernandogbs.entities.*;


import java.io.*;
import java.time.LocalDate;
import java.util.*;


/*MEMBROS DO GRUPO*/
// FERNANDO GUSTAVO B. SANTOS
// João Paulo Rosa Batista
// Gabriel de Jesus Ribeiro
// Arthur Galvão Loureiro Argôlo
// Felipe Souza Teixeira da Silva

public class SistemaReservas {

    public static void main(String[] args) {
        Sistema sistema = new Sistema(); //Instancia a classe responsável pelo conjunto de estrutura de dados
        Scanner scanner = new Scanner(System.in); //Classe I/O do java.

        /*Menu inicial*/
        while (true) {
            System.out.println("\n=== Sistema de Reservas de Hotel ===");
            System.out.println("1. Adicionar Hóspede");
            System.out.println("2. Adicionar Quarto");
            System.out.println("3. Criar Reserva");
            System.out.println("4. Consultar Reservas por Hóspede");
            System.out.println("5. Consultar Reservas por Data");
            System.out.println("6. Cancelar Reserva");
            System.out.println("7. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            /*Define a opção a ser utilizada pelo usuário, chamando a estrutura de dados responsável pela task*/
            switch (opcao) {
                case 1:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    sistema.adicionarHospede(nomeHospede, telefone, email);
                    break;
                case 2:
                    System.out.print("Número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Tipo: ");
                    String tipoQuarto = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoQuarto = scanner.nextDouble();
                    sistema.adicionarQuarto(numeroQuarto, tipoQuarto, precoQuarto);
                    break;
                case 3:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospedeReserva = scanner.nextLine();
                    System.out.print("Número do quarto: ");
                    int numeroQuartoReserva = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Data de check-in (AAAA-MM-DD): ");
                    String checkInStr = scanner.nextLine();
                    LocalDate checkIn = LocalDate.parse(checkInStr);
                    System.out.print("Data de check-out (AAAA-MM-DD): ");
                    String checkOutStr = scanner.nextLine();
                    LocalDate checkOut = LocalDate.parse(checkOutStr);
                    sistema.criarReserva(nomeHospedeReserva, numeroQuartoReserva, checkIn, checkOut);
                    break;
                case 4:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospedeConsulta = scanner.nextLine();
                    sistema.consultarReservasPorHospede(nomeHospedeConsulta);
                    break;
                case 5:
                    System.out.print("Data (AAAA-MM-DD): ");
                    String dataStr = scanner.nextLine();
                    LocalDate dataConsulta = LocalDate.parse(dataStr);
                    sistema.consultarReservasPorData(dataConsulta);
                    break;
                case 6:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospedeCancelamento = scanner.nextLine();
                    System.out.print("Data de check-in da reserva a ser cancelada (AAAA-MM-DD): ");
                    String checkInCancelamentoStr = scanner.nextLine();
                    LocalDate checkInCancelamento = LocalDate.parse(checkInCancelamentoStr);
                    sistema.cancelarReserva(nomeHospedeCancelamento, checkInCancelamento);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}

