package com.fernandogbs.entities;

import java.io.Serializable;

public class Quarto implements Serializable {
    private int numero;
    private String tipo;
    private double preco;

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

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
