
-------------- Criação das tabelas iniciais do sistema -------------------

CREATE TABLE usuario (
    codigo bigint CONSTRAINT pk_usuario PRIMARY KEY,
    nome character varying(150) NOT NULL,
    email character varying(100),
    senha character varying(50) NOT NULL,
    login character varying(50) NOT NULL,
    perfil character varying(50) default 'USUARIO' NOT NULL,
    status character varying(50) default 'INATIVO' NOT NULL
);

ALTER TABLE usuario OWNER TO postgres;

ALTER TABLE usuario
  ADD UNIQUE (login);

CREATE SEQUENCE usuario_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE usuario_codigo_seq OWNER TO postgres;

ALTER TABLE usuario ALTER COLUMN codigo SET DEFAULT NEXTVAL('usuario_codigo_seq'::regclass);

CREATE TABLE curso (
    codigo bigint CONSTRAINT pk_curso PRIMARY KEY,
	conteudo varchar(255), 
	nome varchar(255), 
	nota decimal, 
	plataforma varchar(255)
);

ALTER TABLE curso OWNER TO postgres;

CREATE SEQUENCE curso_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE curso_codigo_seq OWNER TO postgres;

ALTER TABLE curso ALTER COLUMN codigo SET DEFAULT NEXTVAL('curso_codigo_seq'::regclass);

CREATE TABLE dominio_fixo (
    codigo bigint CONSTRAINT pk_dominio_fixo PRIMARY KEY,
	chave_entidade varchar,
	descricao varchar(255)
);

ALTER TABLE dominio_fixo OWNER TO postgres;

