-- Table: public.saman

-- DROP TABLE IF EXISTS public.saman;

CREATE TABLE IF NOT EXISTS public.saman
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    card_name text COLLATE pg_catalog."default" NOT NULL,
    operation text COLLATE pg_catalog."default" NOT NULL,
    amount integer NOT NULL,
    reason text COLLATE pg_catalog."default" NOT NULL,
    date date NOT NULL,
    "time" time with time zone,
    balance integer,
    CONSTRAINT saman_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.saman
    OWNER to postgres;