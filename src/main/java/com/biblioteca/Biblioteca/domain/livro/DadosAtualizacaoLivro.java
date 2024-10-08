package com.biblioteca.Biblioteca.domain.livro;

import java.util.Date;

public record DadosAtualizacaoLivro(Long id, String titulo, String autor, String editora, Date data) {
}
