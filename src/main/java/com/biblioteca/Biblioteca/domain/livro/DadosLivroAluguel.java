package com.biblioteca.Biblioteca.domain.livro;

public record DadosLivroAluguel(Long id, String titulo) {
    public DadosLivroAluguel(Livro livro) {
        this(livro.getId(), livro.getTitulo());
    }
}
