package com.biblioteca.Biblioteca.controller;

import com.biblioteca.Biblioteca.domain.aluguel.*;
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
@RequestMapping("/aluguel")
@SecurityRequirement(name = "bearer-key")
public class AluguelController {

    @Autowired
    private AgendaAluguel agenda;

    @Autowired
    private AluguelRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluguel dados) {
        var aluguel = agenda.agendaAluguel(dados);

        return ResponseEntity.ok(aluguel);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluguel>> listar(@PageableDefault(size = 10, sort = {"data"})Pageable paginacao) {
        var aluguel = repository.findAll(paginacao).map(DadosListagemAluguel::new);

        return ResponseEntity.ok(aluguel);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterar(@RequestBody @Valid DadosAtualizacaoAluguel dados) {
        var aluguel = repository.getReferenceById(dados.id());
        agenda.atualizarAluguel(dados);

        return ResponseEntity.ok(new DadosListagemAluguel(aluguel));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var aluguel = repository.getReferenceById(id);

        repository.delete(aluguel);
        return ResponseEntity.noContent().build();
    }



}
