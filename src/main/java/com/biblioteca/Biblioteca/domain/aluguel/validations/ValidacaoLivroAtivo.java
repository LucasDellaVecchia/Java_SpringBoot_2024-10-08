package com.biblioteca.Biblioteca.domain.aluguel.validations;

import com.biblioteca.Biblioteca.domain.aluguel.DadosCadastroAluguel;
import com.biblioteca.Biblioteca.domain.livro.LivroRepository;
import com.biblioteca.Biblioteca.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoLivroAtivo implements ValidacaoAluguel{

    @Autowired
    private LivroRepository repository;

    public void validar(DadosCadastroAluguel dados) {
        var livro = repository.findAtivoById(dados.idLivro());

        if (!livro) {
            throw new ValidacaoException("O livro está inativo!");
        }

    }
}
