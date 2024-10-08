package com.biblioteca.Biblioteca.domain.aluguel;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroAluguel(
        @NotNull
        Long idLivro,

        @NotNull
        Long idCliente,

        @NotNull
        Long idUsuario,

        @NotNull
        @Future
        LocalDateTime data
) {
}
