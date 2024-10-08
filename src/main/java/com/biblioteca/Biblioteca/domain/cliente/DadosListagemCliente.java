package com.biblioteca.Biblioteca.domain.cliente;

import java.util.Date;

public record DadosListagemCliente(Long id, String nome, String cpf, Date data) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getData());
    }
}
