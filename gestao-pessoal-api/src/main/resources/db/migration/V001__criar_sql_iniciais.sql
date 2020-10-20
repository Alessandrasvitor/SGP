
-------------- Criação das tabelas iniciais do sistema -------------------

CREATE TABLE usuario (
    codigo bigint CONSTRAINT pk_usuario PRIMARY KEY,
    nome character varying(150) NOT NULL,
    email character varying(100),
    senha character varying(50) NOT NULL,
    perfil character varying(50) default 'PADRAO' NOT NULL,
    status character varying(50) default 'INATIVO' NOT NULL
);

ALTER TABLE usuario OWNER TO postgres;

ALTER TABLE usuario
  ADD UNIQUE (email);

CREATE SEQUENCE usuario_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE usuario_codigo_seq OWNER TO postgres;

ALTER TABLE usuario ALTER COLUMN codigo SET DEFAULT NEXTVAL('usuario_codigo_seq'::regclass);

CREATE SEQUENCE instituicao_ensino_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

create table instituicao_ensino(
	codigo bigint DEFAULT nextval('instituicao_ensino_id_seq'::regclass) not null CONSTRAINT pk_id_instituicao_ensino PRIMARY KEY,
	endereco varchar(100) not null,
	descricao varchar(500) not null,
	relevancia integer not null
);

CREATE TABLE curso (
    codigo bigserial CONSTRAINT pk_curso PRIMARY KEY,
	conteudo varchar(255), 
	nome varchar(255), 
	nota decimal, 
	instituicao bigint,
  CONSTRAINT instituicao_fk FOREIGN KEY (instituicao)
    REFERENCES public.instituicao_ensino(codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

ALTER TABLE curso OWNER TO postgres;

ALTER TABLE curso ALTER COLUMN codigo SET DEFAULT NEXTVAL('curso_codigo_seq'::regclass);

CREATE TABLE dominio_fixo (
    codigo bigint CONSTRAINT pk_dominio_fixo PRIMARY KEY,
	chave_entidade varchar,
	descricao varchar(255)
);

ALTER TABLE dominio_fixo OWNER TO postgres;

