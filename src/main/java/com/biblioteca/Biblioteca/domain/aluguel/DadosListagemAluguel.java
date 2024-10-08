package com.biblioteca.Biblioteca.domain.aluguel;

import com.biblioteca.Biblioteca.domain.cliente.Cliente;
import com.biblioteca.Biblioteca.domain.cliente.DadosClienteAluguel;
import com.biblioteca.Biblioteca.domain.livro.DadosLivroAluguel;
import com.biblioteca.Biblioteca.domain.livro.Livro;
import com.biblioteca.Biblioteca.domain.usuario.DadosUsuarioAluguel;
import com.biblioteca.Biblioteca.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosListagemAluguel(
        Long id,
        DadosLivroAluguel idLivro,
        DadosClienteAluguel idCliente,
        DadosUsuarioAluguel idUsuario,
        LocalDateTime data
) {
    public DadosListagemAluguel(Aluguel aluguel) {
        this(
                aluguel.getId(),
                new DadosLivroAluguel(aluguel.getIdLivro()),
                new DadosClienteAluguel(aluguel.getIdCliente()),
                new DadosUsuarioAluguel(aluguel.getIdUsuario()),
                aluguel.getData()
        );
    }
}
