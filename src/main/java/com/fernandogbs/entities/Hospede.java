package com.fernandogbs.entities;

import java.io.Serializable;

public class Hospede implements Serializable {
    //definição de variaveis constantes
    private final String nome;
    private final String telefone;
    private final String email;

    //construtor
    public Hospede(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    //impressão de informações do hospede
    @Override
    public String toString() {
        return "Hospede{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}