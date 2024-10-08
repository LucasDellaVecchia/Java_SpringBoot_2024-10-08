create table clientes (
    id bigint not null auto_increment,
    nome varchar(250) not null,
    cpf varchar(15) not null,
    data date not null,
    ativo tinyint not null,

    primary key(id)
);

create table livros (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    autor varchar(255) not null,
    editora varchar(100) not null,
    data date not null,
    ativo tinyint not null,

    primary key(id)
);