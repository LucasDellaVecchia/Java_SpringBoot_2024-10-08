package com.biblioteca.Biblioteca.domain.aluguel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    Page<Aluguel> findAll(Pageable paginacao);

}
