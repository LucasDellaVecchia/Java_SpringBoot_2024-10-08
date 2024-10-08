package com.biblioteca.Biblioteca.domain.cliente;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotNull
        Date data) {
}
