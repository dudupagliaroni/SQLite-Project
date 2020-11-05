drop table if exists person;
create table if not exists person (
id integer not null AUTO_INCREMENT primary key,
name string,
idade int,
endereco string
);


