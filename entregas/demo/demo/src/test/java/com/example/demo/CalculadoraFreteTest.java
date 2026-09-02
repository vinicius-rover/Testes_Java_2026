package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraFreteTest {

    @ParameterizedTest
    @CsvSource({
            "1.0, false, 10.00",
            "1.0, true, 15.00",
            "2.0, false, 12.00",
            "2.0, true, 18.00",
            "5.0, false, 18.00",
            "5.0, true, 27.00",
            "0.01, false, 8.02"
    })
    void deveCalcularFreteCorretamente(
            double pesoKg,
            boolean entregaExpressa,
            double valorEsperado) {

        // Act
        double resultado = CalculadoraFrete.calcular(
                pesoKg,
                entregaExpressa
        );

        // Assert
        assertEquals(valorEsperado, resultado, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            0.0,
            -0.01,
            -1.0,
            -10.0
    })
    void deveLancarExcecaoParaPesoInvalido(double pesoKg) {

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(
                        pesoKg,
                        false
                )
        );

        // Assert
        assertEquals(
                "O peso deve ser maior que zero.",
                excecao.getMessage()
        );
    }
}
