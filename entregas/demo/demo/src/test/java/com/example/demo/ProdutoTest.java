package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void calcularValorEmEstoqueDeveMultiplicarPrecoPelaQuantidade() {
        // Arrange
        Produto produto = new Produto("Banana", 20.0, 10);

        // Act
        double obtido = produto.calcularValorEmEstoque();

        // Assert
        assertEquals(200.0, obtido, 0.001);
    }

    @Test
    void deveRetornarTrueQuandoHouverProdutosNoEstoque() {
        // Arrange
        Produto produto = new Produto("Banana", 20.0, 10);

        // Act
        boolean resultado = produto.temEstoque();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoEstoqueFor0() {
        // Arrange
        Produto produto = new Produto("Banana", 20.0, 0);

        // Act
        boolean resultado = produto.temEstoque();

        // Assert
        assertFalse(resultado);
    }

    @Test
    void deveLancarExcecaoQuandoPrecoFor0() {
        // Arrange
        double preco = 0;

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Banana", preco, 10)
        );

        // Assert
        assertEquals(
                "O preço deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForNegativo() {
        // Arrange
        double preco = -20.0;

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Banana", preco, 10)
        );

        // Assert
        assertEquals(
                "O preço deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    void deveLancarExcecaoQuandoEstoqueForNegativo() {
        // Arrange
        int estoque = -1;

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Banana", 20.0, estoque)
        );

        // Assert
        assertEquals(
                "O estoque não pode ser negativo.",
                excecao.getMessage()
        );
    }
}
