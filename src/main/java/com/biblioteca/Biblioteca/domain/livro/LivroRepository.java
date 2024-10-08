package com.biblioteca.Biblioteca.domain.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT
            l.ativo
            FROM
            Livro l
            WHERE
            l.id = :idLivro
            """)
    boolean findAtivoById(Long idLivro);

}
