/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pit.versoes;

import com.mycompany.pit.AvaliacaoAluno;
import static com.mycompany.pit.AvaliacaoAluno.Situacao.APROVADO;
import static com.mycompany.pit.AvaliacaoAluno.Situacao.EXAME;
import static com.mycompany.pit.AvaliacaoAluno.Situacao.REPROVADO;
import static com.mycompany.pit.AvaliacaoAluno.Situacao.REPROVADO_POR_FALTA;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pablo Floriano
 */
public class AvaliacaoAlunoTest {
    private final AvaliacaoAluno avaliacao = new AvaliacaoAluno();

    // ---------- Média ----------

    @Test
    void mediaMaximaEhDez() {
        assertEquals(10.0, avaliacao.calcularMedia(10, 10), 0.001);
    }

    @Test
    void mediaMinimaEhZero() {
        assertEquals(0.0, avaliacao.calcularMedia(0, 0), 0.001);
    }

    // ---------- Situação por média (valores-limite) ----------

    @Test
    void mediaExatamenteSeteEhAprovado() {
        assertEquals(APROVADO, avaliacao.situacao(7, 7, 100));
    }

    @Test
    void mediaLogoAbaixoDeSeteEhExame() {
        assertEquals(EXAME, avaliacao.situacao(6.9, 6.9, 100));
    }

    @Test
    void mediaExatamenteQuatroEhExame() {
        assertEquals(EXAME, avaliacao.situacao(4, 4, 100));
    }

    @Test
    void mediaLogoAbaixoDeQuatroEhReprovado() {
        assertEquals(REPROVADO, avaliacao.situacao(3.9, 3.9, 100));
    }

    // ---------- Frequência ----------

    @Test
    void frequenciaExatamente75NaoReprovaPorFalta() {
        assertEquals(APROVADO, avaliacao.situacao(8, 8, 75));
    }

    @Test
    void frequenciaLogoAbaixoDe75ReprovaPorFalta() {
        assertEquals(REPROVADO_POR_FALTA, avaliacao.situacao(8, 8, 74.9));
    }

    @Test
    void faltaTemPrioridadeSobreNota() {
        assertEquals(REPROVADO_POR_FALTA, avaliacao.situacao(10, 10, 0));
    }

    @Test
    void frequenciaZeroECemSaoValidas() {
        assertDoesNotThrow(() -> avaliacao.situacao(5, 5, 0));
        assertDoesNotThrow(() -> avaliacao.situacao(5, 5, 100));
    }

    @Test
    void frequenciaNegativaEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.situacao(5, 5, -1));
    }

    @Test
    void frequenciaAcimaDeCemEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.situacao(5, 5, 100.1));
    }

    // ---------- Validação de notas ----------

    @Test
    void notasZeroEDezSaoValidas() {
        assertDoesNotThrow(() -> avaliacao.situacao(10, 10, 100));
        assertDoesNotThrow(() -> avaliacao.situacao(0, 0, 100));
    }

    @Test
    void p1NegativaEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.calcularMedia(-0.1, 5));
    }

    @Test
    void p2NegativaEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.calcularMedia(5, -0.1));
    }

    @Test
    void p1AcimaDeDezEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.calcularMedia(10.1, 5));
    }

    @Test
    void p2AcimaDeDezEhInvalida() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.calcularMedia(5, 10.1));
    }
    
    // ---------- Validação de notas ----------
    
    @Test
    void bonusLogoAcimaDeUmEhInvalido() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.situacao(0.0, 0.0, 75.0, 1.1));
    }
    
    @Test
    void bonusLogoAbaixoDeZeroEhInvalido() {
        assertThrows(IllegalArgumentException.class, () -> avaliacao.situacao(0.0, 0.0, 75.0, -0.1));
    }
    
}
