CREATE TABLE IF NOT EXISTS public.bag
(
    id integer NOT NULL,
    cost double precision DEFAULT 0,
    weight double precision DEFAULT 0,
    brand text COLLATE pg_catalog."default",
    type text COLLATE pg_catalog."default",
    color text COLLATE pg_catalog."default",
    CONSTRAINT bag_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bag
    OWNER to postgres;

INSERT INTO public.bag(
	id, cost, weight, brand, type, color) VALUES
	 (1, 1, 1, 'brand1', 'type1', 'color1'),
	 (2, 2, 2, 'brand2', 'type2', 'color2'),
	 (3, 3, 3, 'brand3', 'type3', 'color3'),
	 (4, 4, 4, 'brand4', 'type4', 'color4'),
	 (5, 5, 5, 'brand5', 'type5', 'color5');


CREATE TABLE IF NOT EXISTS public.usr
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    email text COLLATE pg_catalog."default" UNIQUE,
    phone_number text COLLATE pg_catalog."default",
    name text COLLATE pg_catalog."default",
    active boolean,
    password text COLLATE pg_catalog."default",
	role text COLLATE pg_catalog."default",
    CONSTRAINT usr_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usr
    OWNER to postgres;

INSERT INTO usr (email, phone_number, name, active, password, role) VALUES
('user@mail.ru','8999999999', 'vitalii', TRUE, 'user', 'USER'),
('admin@mail.ru','8999999999', 'dima', TRUE, 'admin', 'ADMIN'),
('tankist@gmail.com', '8999999999', 'andrei',TRUE, '12345',  'USER');
