package com.biblioteca.Biblioteca.domain.aluguel;

import com.biblioteca.Biblioteca.domain.aluguel.validations.ValidacaoAluguel;
import com.biblioteca.Biblioteca.domain.cliente.ClienteRepository;
import com.biblioteca.Biblioteca.domain.livro.LivroRepository;
import com.biblioteca.Biblioteca.domain.usuario.UsuarioRepository;
import com.biblioteca.Biblioteca.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaAluguel {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidacaoAluguel> validacoes;

    public DadosListagemAluguel agendaAluguel(DadosCadastroAluguel dados) {

        if (checarDados(dados.idLivro(), dados.idCliente(), dados.idUsuario(), dados.data())) {
            validacoes.forEach(v -> v.validar(dados));

            var livro = livroRepository.getReferenceById(dados.idLivro());
            var cliente = clienteRepository.getReferenceById(dados.idCliente());
            var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
            var data = dados.data();

            var aluguel = new Aluguel(null, livro, cliente, usuario, data);
            aluguelRepository.save(aluguel);

            return new DadosListagemAluguel(aluguel);
        }

        return null;
    }

    public void atualizarAluguel(DadosAtualizacaoAluguel dados) {

        if(checarDados(dados.idLivro(), dados.idCliente(), dados.idUsuario(), dados.data())) {
            var aluguel = aluguelRepository.getReferenceById(dados.id());

            var livro = livroRepository.getReferenceById(dados.idLivro());
            var cliente = clienteRepository.getReferenceById(dados.idCliente());
            var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
            var data = dados.data();

            aluguel.setIdCliente(cliente);
            aluguel.setIdLivro(livro);
            aluguel.setIdUsuario(usuario);
            aluguel.setData(data);

            aluguelRepository.save(aluguel);

        }

    }


    public boolean checarDados(Long idLivro, Long idCliente, Long idUsuario, LocalDateTime data) {

        if (!clienteRepository.existsById(idCliente)) {
            throw new ValidacaoException("Este cliente não está cadastrado!");
        }

        if (!livroRepository.existsById(idLivro)) {
            throw new ValidacaoException("Este livro não está cadastrado!");
        }

        if (!usuarioRepository.existsById(idUsuario)) {
            throw new ValidacaoException("Este usuário não está cadastrado!");
        }
        return true;

    }
}
