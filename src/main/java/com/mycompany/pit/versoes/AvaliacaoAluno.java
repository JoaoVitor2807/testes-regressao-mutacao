/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pit.versoes;

public class AvaliacaoAluno {
    
    public enum Situacao { APROVADO, EXAME, REPROVADO, REPROVADO_POR_FALTA }

    public static final double MEDIA_APROVACAO = 7.0;
    public static final double MEDIA_EXAME = 4.0;
    public static final double FREQUENCIA_MINIMA = 75.0;

    public double calcularMedia(double p1, double p2) {
        return calcularMedia(p1, p2, 0.0);
    }

    public double calcularMedia(double p1, double p2, double bonus) {
        validarNota(p1);
        validarNota(p2);
        validarBonus(bonus);
        return (p1 + p2)/2 + bonus;
    }

    public Situacao situacao(double p1, double p2, double frequencia) {
        return situacao(p1, p2, frequencia, 0.0);
    }

    public Situacao situacao(double p1, double p2, double frequencia, double bonus) {
        validarFrequencia(frequencia);
        if (frequencia < FREQUENCIA_MINIMA) {
            return Situacao.REPROVADO_POR_FALTA;
        }
        double media = calcularMedia(p1, p2, bonus);
        if (media >= MEDIA_APROVACAO) {
            return Situacao.APROVADO;
        }
        if (media >= MEDIA_EXAME) {
            return Situacao.EXAME;
        }
        return Situacao.REPROVADO;
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
    }

    private void validarFrequencia(double frequencia) {
        if (frequencia < 0 || frequencia > 100) {
            throw new IllegalArgumentException("Frequência inválida");
        }
    }

    private void validarBonus(double bonus) {
        if (bonus < 0 || bonus > 1) {
            throw new IllegalArgumentException("Bônus deve estar entre 0 e 1");
        }
    }
}
