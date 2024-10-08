package com.biblioteca.Biblioteca.domain.cliente;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

public record DadosAtualizacaoCliente(Long id, String nome, String cpf, Date data) {
}
