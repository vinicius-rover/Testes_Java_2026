package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void usuarioRecemCriadoDeveTerTelefoneNulo() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        String telefone = usuario.getTelefone();

        // Assert
        assertNull(telefone);
    }

    @Test
    void usuarioRecemCriadoDeveEstarAtivo() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        boolean resultado = usuario.isAtivo();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void depoisDeDefinirTelefoneNaoDeveSerNulo() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        usuario.definirTelefone("47999999999");

        // Assert
        assertNotNull(usuario.getTelefone());
    }

    @Test
    void telefoneObtidoDeveSerIgualAoInformado() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");
        String telefone = "47999999999";

        // Act
        usuario.definirTelefone(telefone);

        // Assert
        assertEquals(telefone, usuario.getTelefone());
    }

    @Test
    void telefoneNuloDeveLancarExcecao() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> usuario.definirTelefone(null)
        );

        // Assert
        assertEquals(
                "O telefone é obrigatório.",
                excecao.getMessage()
        );
    }

    @Test
    void telefoneEmBrancoDeveLancarExcecao() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> usuario.definirTelefone("   ")
        );

        // Assert
        assertEquals(
                "O telefone é obrigatório.",
                excecao.getMessage()
        );
    }

    @Test
    void desativarDeveAlterarEstadoParaInativo() {
        // Arrange
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Act
        usuario.desativar();

        // Assert
        assertFalse(usuario.isAtivo());
    }

    @Test
    void usuarioRecemCriadoDeveTerEstadoInicialCorreto() {
        // Arrange + Act
        Usuario usuario = new Usuario("Rover", "rover@email.com");

        // Assert
        assertAll(
                () -> assertEquals("Rover", usuario.getNome()),
                () -> assertEquals("rover@email.com", usuario.getEmail()),
                () -> assertNull(usuario.getTelefone()),
                () -> assertTrue(usuario.isAtivo())
        );
    }
}
