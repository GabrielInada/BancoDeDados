-- inserindo alguns estados
insert into estado (id, nome, sigla) values (1, 'Pará', 'PA');
insert into estado (id, nome, sigla) values (2, 'Amapá', 'AP');
insert into estado (id, nome, sigla) values 
    (3, 'Roraima', 'RR'),
    (4, 'Rondônia', 'RO'),
    (5, 'Amazonas', 'AM');
insert into estado (nome, sigla) values ('São Paulo', 'SP');

-- inserindo algumas cidades
insert into cidade (nome, populacao, area, estado) values ('Belém', 1500000, 1000, 1);
insert into cidade (nome, populacao, area, estado) values 
    ('Macapá', 522000, 6500, 2),
    ('Boa Vista', 436000, 5600, 3),
    ('Porto Velho', 548000, 34000, 4),
    ('Manaus', 2200000, 11400, 5),
    ('São Paulo', 12400000, 1500, 6);