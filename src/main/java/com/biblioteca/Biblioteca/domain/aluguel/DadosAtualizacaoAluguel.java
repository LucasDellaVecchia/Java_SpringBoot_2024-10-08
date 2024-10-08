package com.biblioteca.Biblioteca.domain.aluguel;

import java.time.LocalDateTime;

public record DadosAtualizacaoAluguel(
        Long id,
        Long idLivro,
        Long idCliente,
        Long idUsuario,
        LocalDateTime data
) {
}
