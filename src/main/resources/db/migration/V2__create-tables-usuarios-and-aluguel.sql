create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)

);

create table aluguel(
    id bigint not null auto_increment,
    livro_id bigint not null,
    cliente_id bigint not null,
    usuario_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_aluguel_livro_id foreign key(livro_id) references livros(id),
    constraint fk_aluguel_cliente_id foreign key(cliente_id) references clientes(id),
    constraint fk_aluguel_usuario_id foreign key(usuario_id) references usuarios(id)
);