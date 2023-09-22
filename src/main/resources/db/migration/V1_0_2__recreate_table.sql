-- Table: public.transaction

-- DROP TABLE IF EXISTS public.transaction;

CREATE TABLE IF NOT EXISTS public.transaction
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    operation text COLLATE pg_catalog."default" NOT NULL,
    amount integer NOT NULL,
    reason text COLLATE pg_catalog."default" NOT NULL,
    date date NOT NULL,
    "time" time without time zone,
    balance integer,
    CONSTRAINT transaction_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction
    OWNER to postgres;