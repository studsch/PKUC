create database bag owner postgres;
\connect bag
CREATE TABLE IF NOT EXISTS bag (
     id int,
     material varchar,
     brand varchar,
     country varchar,
     height int,
     width int,
     depth int
);

INSERT INTO  bag (id, material, brand, country, height, width, depth)
VALUES (1, 'material1', 'brand1', 'country1', 1, 1, 1),
       (2, 'material2', 'brand2', 'country2', 2, 2, 2),
       (3, 'material3', 'brand3', 'country3', 3, 3, 3),
       (4, 'material4', 'brand4', 'country4', 4, 4, 4);

CREATE TABLE IF NOT EXISTS myUsers (
    id int,
    login varchar,
    password varchar,
    role varchar
);

INSERT INTO  bag (id, login, password, role)
VALUES (1, 'admin', 'admin', 'ADMIN'),
       (2, 'user', 'user', 'USER');