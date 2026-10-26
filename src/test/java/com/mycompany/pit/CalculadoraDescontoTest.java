/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pablo Floriano
 */
public class CalculadoraDescontoTest {
    private final CalculadoraDesconto calc = new CalculadoraDesconto();

    @Test
    void compraPequenaNaoTemDesconto() {
        assertEquals(0.0, calc.calcularDesconto(50.0, false), 0.001);
    }

    @Test
    void compraMediaTemCincoPorCento() {
        assertEquals(15.0, calc.calcularDesconto(300.0, false), 0.001);
    }

    @Test
    void compraGrandeVipTemQuinzePorCento() {
        assertEquals(150.0, calc.calcularDesconto(1000.0, true), 0.001);
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularDesconto(-10.0, false));
    }

    @Test
    void valorFinalEhCalculado() {
        calc.calcularValorFinal(200.0, false); // executa, mas não verifica nada!
    }

}
