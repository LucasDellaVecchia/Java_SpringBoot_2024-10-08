package com.biblioteca.Biblioteca.controller;

import com.biblioteca.Biblioteca.domain.livro.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@SecurityRequirement(name = "bearer-key")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLivro dados) {
        var livro = new Livro(dados);

        repository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLivro>> listar(@PageableDefault(size = 10, sort = {"titulo"})Pageable paginacao) {
        var pagina = repository.findAllByAtivoTrue(paginacao).map(DadosListagemLivro::new);

        return ResponseEntity.ok(pagina);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados) {
        var livro = repository.getReferenceById(dados.id());
        livro.atualizarDados(dados);

        return ResponseEntity.ok(new DadosListagemLivro(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        livro.excluir();

        return ResponseEntity.noContent().build();
    }

}
