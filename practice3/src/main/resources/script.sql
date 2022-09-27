create database bag owner postgres;
\connect bag
CREATE TABLE bag (
     id int,
     material varchar,
     brand varchar,
     country varchar,
     height int,
     width int,
     depth int
);