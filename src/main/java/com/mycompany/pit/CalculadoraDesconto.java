/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pit;

/**
 *  - Valor negativo: lança IllegalArgumentException
 *  - Compras a partir de R$ 500,00: 10% de desconto
 *  - Compras a partir de R$ 100,00: 5% de desconto
 *  - Abaixo de R$ 100,00: sem desconto
 *  - Cliente VIP: +5% sobre o percentual da faixa
 */
public class CalculadoraDesconto {
    public static final double LIMITE_FAIXA_1 = 100.0;
    public static final double LIMITE_FAIXA_2 = 500.0;

    public double calcularDesconto(double valorCompra, boolean clienteVip) {
        if (valorCompra < 0) {
            throw new IllegalArgumentException("Valor da compra não pode ser negativo");
        }

        double percentual;
        if (valorCompra >= LIMITE_FAIXA_2) {
            percentual = 0.10;
        } else if (valorCompra >= LIMITE_FAIXA_1) {
            percentual = 0.05;
        } else {
            percentual = 0.0;
        }

        if (clienteVip) {
            percentual += 0.05;
        }

        return valorCompra * percentual;
    }

    public double calcularValorFinal(double valorCompra, boolean clienteVip) {
        return valorCompra - calcularDesconto(valorCompra, clienteVip);
    }
}
