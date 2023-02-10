-- criando o banco de dados
create database aula_bd;


-- criando a primeira tabela do banco de dados
create table aluno (
id int,
nome varchar(50),
email varchar(150),
celular varchar(11)
);


-- operações CRUD na tabela aluno
insert into aluno values (1, ‘Fulano’, ‘fulano@email.com’, ‘91988774433’);

select * from aluno;

update aluno set nome = ‘Beltrano’ where id = 1;

delete from aluno where id = 1;

select nome, email from aluno;


-- alterando a tabela aluno para acrecentar campo nascimento
alter table aluno add nascimento date;


-- alterando a tabela aluno para acrescentar constraints
alter table aluno modify nome varchar(50) not null;

alter table aluno modify nascimento date not null;

alter table aluno modify email varchar(150) unique not null;

alter table aluno modify id int primary key;


-- criando a tabela com constraints
-- drop table aluno;
create table aluno (
id int primary key,
nome varchar(50) not null,
email varchar(150) unique not null,
celular varchar(11),
nascimento date not null ) ;


-- alterando a tabela aluno para acrecentar o campo mae após nome
alter table aluno add mae varchar(100) not null after nome;


-- alterando a tabela aluno para excluir o campo mae
alter table aluno drop column mae;


-- alterando a tabela aluno para renomear o campo nascimentoALTER TABLE 
alter table aluno change column nascimento data_nascimento date not null;


-- criando as tabelas cidade e estado
create table cidade (
	id int primary key,
	nome varchar(50) not null,
	populacao int,
	area int
);

create table estado(
	id int primary key,
	nome varchar(50) not null,
	sigla char(2) not null
);


-- alterando a tabela aluno para incluir a foreign key para cidade
alter table aluno add cidade int;

alter table aluno add foreign key fk_cidade (cidade) references cidade (id);


-- alterando a tabela cidade para incluir a foreign key para estado
alter table cidade add estado int;

alter table cidade add foreign key fk_estado (estado) references estado (id);


-- inserindo registro em estado
insert into estado (id, nome, sigla) values (1, ‘pará’, ‘pa’);

-- inserindo vários registros em estado
insert into estado (id, nome, sigla) values
	(2, ‘amapá’, ‘ap’),
	(3, ‘roraima’, ‘rr’) ,
	(4, ‘rondônia’, ‘ro’);


-- algumas seleções na tabela aluno
select id, nome, cidade from aluno;

select id, nome, cidade from aluno order by email desc;

select id, nome, cidade from aluno where cidade is null;


-- junção de tabelas
select a.*, c.* from aluno a, cidade c;

select a.*, c.* from aluno a, cidade c where a.cidade = c.id;

select a.nome, c.nome from aluno a inner join cidade c on (a.cidade = c.id);

select a.nome, c.nome from aluno a left join cidade c on (a.cidade = c.id);

select a.nome, c.nome from aluno a right join cidade c on (a.cidade = c.id);