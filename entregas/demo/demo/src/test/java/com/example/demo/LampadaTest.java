package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    void lampadaRecemCriadaDeveEstarDesligada() {
        // Arrange
        Lampada lampada = new Lampada("Sala");

        // Assert
        assertFalse(lampada.isLigada());
    }

    @Test
    void lampadaRecemCriadaDeveTerIntensidadeZero() {
        // Arrange
        Lampada lampada = new Lampada("Sala");

        // Assert
        assertEquals(0, lampada.getIntensidade());
    }

    @Test
    void ligarDeveAlterarEstadoDaLampada() {
        // Arrange
        Lampada lampada = new Lampada("Sala");

        // Act
        lampada.ligar();

        // Assert
        assertTrue(lampada.isLigada());
        assertEquals(100, lampada.getIntensidade());
    }

    @Test
    void ligarDeveAlterarIntensidadePara100() {
        // Arrange
        Lampada lampada = new Lampada("Sala");

        // Act
        lampada.ligar();

        // Assert
        assertEquals(100, lampada.getIntensidade());
    }

    @Test
    void desligarDeveRestaurarEstadoEIntensidadeIniciais() {
        // Arrange
        Lampada lampada = new Lampada("Sala");
        lampada.ligar();

        // Act
        lampada.desligar();

        // Assert
        assertFalse(lampada.isLigada());
        assertEquals(0, lampada.getIntensidade());
    }
}
