drop table if exists books;
drop table if exists users;

create table if not exists books (
    id      serial primary key,
    author  varchar(100),
    year    int,
    price   numeric
);

create table if not exists users (
    id             serial primary key,
    name           varchar(100),
    surname        varchar(100),
    birth_year     int
);

insert into books (author, year, price) values ('Vasya', 1999, 1000.00);
insert into books (author, year, price) values ('Petya', 2020, 30.00);
insert into books (author, year, price) values ('Viktor', 2020, 1004.00);
insert into books (author, year, price) values ('Sasha', 1992, 105.00);
insert into books (author, year, price) values ('Dima', 1992, 100.50);
insert into books (author, year, price) values ('Kolya', 1992, 20.50);
insert into books (author, year, price) values ('Ivan', 1999, 399.99);

insert into users (name, surname, birth_year) values ('Vasya', 'Petrov', 1999);
insert into users (name, surname, birth_year) values ('Ivan', 'Ivanov', 2000);
insert into users (name, surname, birth_year) values ('Misha', 'Pyatov', 2001);
insert into users (name, surname, birth_year) values ('Petya', 'Khmelnov', 1999);