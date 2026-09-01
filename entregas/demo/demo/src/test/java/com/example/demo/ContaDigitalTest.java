package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaDigitalTest {

    @Test
    void contaRecemCriadaDeveTerSaldoZero() {
        ContaDigital conta = new ContaDigital("Rover");

        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositarDeveAumentarSaldo() {
        // Arrange
        ContaDigital conta = new ContaDigital("Rover");

        // Act
        conta.depositar(100.0);

        // Assert
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void sacarDeveReduzirSaldo() {
        // Arrange
        ContaDigital conta = new ContaDigital("Rover");
        conta.depositar(100.0);

        // Act
        conta.sacar(40.0);

        // Assert
        assertEquals(60.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositoZeroDeveLancarExcecaoESaldoNaoDeveMudar() {
        ContaDigital conta = new ContaDigital("Rover");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(0.0)
        );

        assertAll(
                () -> assertEquals(
                        "O depósito deve ser maior que zero.",
                        excecao.getMessage()
                ),
                () -> assertEquals(
                        0.0,
                        conta.getSaldo(),
                        0.001
                )
        );
    }

    @Test
    void depositoNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Rover");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-10.0)
        );

        assertEquals(
                "O depósito deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void saqueZeroDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Rover");
        conta.depositar(100.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(0.0)
        );

        assertEquals(
                "O saque deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void saqueNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("Rover");
        conta.depositar(100.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(-10.0)
        );

        assertEquals(
                "O saque deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void saqueMaiorQueSaldoDeveLancarExcecaoESaldoNaoDeveMudar() {
        ContaDigital conta = new ContaDigital("Rover");
        conta.depositar(50.0);

        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> conta.sacar(100.0)
        );

        assertAll(
                () -> assertEquals(
                        "Saldo insuficiente.",
                        excecao.getMessage()
                ),
                () -> assertEquals(
                        50.0,
                        conta.getSaldo(),
                        0.001
                )
        );
    }
}