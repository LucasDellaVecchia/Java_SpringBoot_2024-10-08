package com.biblioteca.Biblioteca.domain.livro;

import java.util.Date;

public record DadosListagemLivro(Long id, String titulo, String autor, String editora, Date data) {

    public DadosListagemLivro(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getData());
    };
}
