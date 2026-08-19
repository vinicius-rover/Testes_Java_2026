package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrianguloTest {

    @Test
    void calcularPerimetroDeveSomarOsTresLados() {
        // Arrange
        Triangulo triangulo = new Triangulo(3, 4, 5);
        // Act
        double perimetro = triangulo.calcularPerimetro();
        // Assert
        assertEquals(12.0, perimetro);
    }

    @Test
    void ladoNegativoDeveLancarExcecao() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Triangulo(-1, 4, 5)
        );
    }

    @Test
    void triangulo3_4_5DeveTerLadosCorretos() {
        Triangulo t = new Triangulo(3, 4, 5);
        assertAll(
                () -> assertEquals(3.0, t.getLadoA()),
                () -> assertEquals(4.0, t.getLadoB()),
                () -> assertEquals(5.0, t.getLadoC())
        );
    }

    @Test
    void construtorDeveInicializarCorretamente() {
        // ARRANGE + ACT: cria um círculo.
        Circulo circulo = new Circulo(3.0);

        // ASSERT: verifica várias propriedades do objeto.
        assertAll(
                "Dados do círculo",
                () -> assertEquals(3.0, circulo.getRaio(), 0.001),
                () -> assertTrue(circulo.calcularArea() > 0),
                () -> assertEquals(
                        Math.PI * 9,
                        circulo.calcularArea(),
                        0.001
                )
        );

    }
}
