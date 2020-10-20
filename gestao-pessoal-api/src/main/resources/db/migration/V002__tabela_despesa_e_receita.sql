
CREATE SEQUENCE despesa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

create table despesa(
	codigo bigint DEFAULT nextval('despesa_id_seq'::regclass) not null CONSTRAINT pk_id_despesa PRIMARY KEY,
	descricao varchar(255) not null,
	valor_pagar decimal(10, 2) not null,
	valor_pago decimal(10, 2)
);

CREATE SEQUENCE receita_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

create table receita(
	id bigint DEFAULT nextval('receita_id_seq'::regclass) not null CONSTRAINT pk_id_receita PRIMARY KEY,
	descricao varchar(255) not null,
	valor_receber decimal(10, 2) not null,
	valor_recebido decimal(10, 2)
);