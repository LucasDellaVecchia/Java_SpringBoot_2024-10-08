package com.biblioteca.Biblioteca.domain.usuario;

public record DadosUsuarioAluguel(Long id, String login) {
    public DadosUsuarioAluguel(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}
