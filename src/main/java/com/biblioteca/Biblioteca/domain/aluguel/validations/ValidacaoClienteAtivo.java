package com.biblioteca.Biblioteca.domain.aluguel.validations;

import com.biblioteca.Biblioteca.domain.aluguel.DadosCadastroAluguel;
import com.biblioteca.Biblioteca.domain.cliente.ClienteRepository;
import com.biblioteca.Biblioteca.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoClienteAtivo implements ValidacaoAluguel{

    @Autowired
    private ClienteRepository repository;

    public void validar(DadosCadastroAluguel dados) {
        var cliente = repository.findAtivoById(dados.idCliente());

        if (!cliente) {
            throw new ValidacaoException("O cliente está inativo!");
        }
    }
}
