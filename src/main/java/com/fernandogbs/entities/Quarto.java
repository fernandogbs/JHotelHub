package com.fernandogbs.entities;

import java.io.Serializable;

public class Quarto implements Serializable {
    //definição de variaveis constantes
    private final int numero;
    private final String tipo;
    private final double preco;

    //Construtor
    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    //getters e setters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    //impressão de informações do Quarto
    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
