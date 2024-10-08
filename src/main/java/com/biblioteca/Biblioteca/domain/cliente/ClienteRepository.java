package com.biblioteca.Biblioteca.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT
            c.ativo
            FROM
            Cliente c
            WHERE
            c.id = :idCliente
            """)
    boolean findAtivoById(Long idCliente);
}
