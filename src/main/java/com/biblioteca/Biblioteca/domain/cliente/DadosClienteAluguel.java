package com.biblioteca.Biblioteca.domain.cliente;

public record DadosClienteAluguel(Long id, String nome) {
    public DadosClienteAluguel(Cliente cliente) {
        this(cliente.getId(), cliente.getNome());
    }
}
