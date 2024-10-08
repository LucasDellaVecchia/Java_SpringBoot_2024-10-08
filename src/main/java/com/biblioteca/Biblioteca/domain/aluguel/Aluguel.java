package com.biblioteca.Biblioteca.domain.aluguel;

import com.biblioteca.Biblioteca.domain.cliente.Cliente;
import com.biblioteca.Biblioteca.domain.livro.Livro;
import com.biblioteca.Biblioteca.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "aluguel")
@Entity(name = "Aluguel")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluguel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private Livro idLivro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario idUsuario;

    private LocalDateTime data;

    public void setIdLivro(Livro idLivro) {
        this.idLivro = idLivro;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Aluguel(Object o, Livro livro, Cliente cliente, Usuario usuario, LocalDateTime data) {
    }


}
