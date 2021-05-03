
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE curso (
    id bigint NOT NULL,
    dt_criacao TIMESTAMP WITH TIME ZONE,
    dt_alteracao TIMESTAMP WITH TIME ZONE,
    nome character varying(255),
    descricao character varying,
    dt_inicio TIMESTAMP WITH TIME ZONE,
    dt_fim TIMESTAMP WITH TIME ZONE,
    intituicao_ensino_id bigint NOT NULL,
    status character varying(25),
    finalizado boolean
);

ALTER TABLE curso OWNER TO postgres;

CREATE SEQUENCE curso_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE curso_codigo_seq OWNER TO postgres;

ALTER SEQUENCE curso_codigo_seq OWNED BY curso.id;


CREATE TABLE instituicao_ensino (
    id bigint NOT NULL,
    dt_criacao TIMESTAMP WITH TIME ZONE,
    dt_alteracao TIMESTAMP WITH TIME ZONE,
    nome character varying(255) NOT NULL,
    endereco character varying(255) NOT NULL,
	nota float4 NULL,
    avaliacao integer
);

ALTER TABLE instituicao_ensino OWNER TO postgres;

CREATE SEQUENCE instituicao_ensino_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE instituicao_ensino_codigo_seq OWNER TO postgres;

ALTER SEQUENCE instituicao_ensino_codigo_seq OWNED BY instituicao_ensino.id;


CREATE TABLE usuario (
    id bigint NOT NULL,
    dt_criacao TIMESTAMP WITH TIME ZONE,
    dt_alteracao TIMESTAMP WITH TIME ZONE,
    nome character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    email character varying(155) NOT NULL,
    perfil character varying(255),
    token character varying(255)
);

ALTER TABLE usuario OWNER TO postgres;

CREATE SEQUENCE usuario_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE usuario_codigo_seq OWNER TO postgres;

ALTER SEQUENCE usuario_codigo_seq OWNED BY usuario.id;


ALTER TABLE ONLY curso ALTER COLUMN id SET DEFAULT nextval('curso_codigo_seq'::regclass);

ALTER TABLE ONLY instituicao_ensino ALTER COLUMN id SET DEFAULT nextval('instituicao_ensino_codigo_seq'::regclass);

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_codigo_seq'::regclass);


SELECT pg_catalog.setval('curso_codigo_seq', 1, false);

SELECT pg_catalog.setval('instituicao_ensino_codigo_seq', 1, false);

SELECT pg_catalog.setval('usuario_codigo_seq', 1, true);


ALTER TABLE ONLY curso
    ADD CONSTRAINT curso_pk PRIMARY KEY (id);

ALTER TABLE ONLY curso
    ADD CONSTRAINT curso_nome_key UNIQUE (nome);

ALTER TABLE ONLY instituicao_ensino
    ADD CONSTRAINT instituicao_ensino_pkey PRIMARY KEY (id);

ALTER TABLE ONLY instituicao_ensino
    ADD CONSTRAINT instituicao_ensino_nome_key UNIQUE (nome);

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id);

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_nome_key UNIQUE (nome);

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_email_key UNIQUE (email);

ALTER TABLE public.curso
  ADD CONSTRAINT curso_instituicao_fk FOREIGN KEY (intituicao_ensino_id)
    REFERENCES public.instituicao_ensino(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;
    
INSERT INTO usuario ( id, dt_criacao, dt_alteracao, nome, senha, email, perfil, token)
	VALUES(1, '2021-04-04', '2021-04-04', 'SuperAdmin', '123456', 'sansyro@gmail.com', 'ADMIN', null);
    	
