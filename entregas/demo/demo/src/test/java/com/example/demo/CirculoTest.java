package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CirculoTest {

    @Test
    void calcularAreaDeveRetornarValorCorreto() {

        Circulo circulo = new Circulo(2.0);


        double area = circulo.calcularArea();


        assertEquals(Math.PI * 4, area, 0.001);
    }

    @Test
    void circuloComRaioMaiorDeveSerIdentificado() {

        Circulo circuloMaior = new Circulo(5.0);
        Circulo circuloMenor = new Circulo(2.0);


        boolean resultado = circuloMaior.ehMaiorQue(circuloMenor);


        assertTrue(resultado);
    }

    @Test
    void criarCirculoComRaioInvalidoDeveLancarExcecao() {

        double raioInvalido = 0.0;


        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Circulo(raioInvalido)
        );


        assertEquals(
                "O raio deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void construtorDeveInicializarCorretamente() {

        Circulo circulo = new Circulo(3.0);


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
