ALTER TABLE usuario ADD permissoes BIGINT;

CREATE TABLE public.permissao (
  usuario_id BIGINT NOT NULL,
  tela_acesso VARCHAR(50),
  CONSTRAINT funcao_usuario FOREIGN KEY (usuario_id)
    REFERENCES public.usuario(codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) 
WITH (oids = false);

INSERT INTO permissao (usuario_id, tela_acesso)
	VALUES (1, 'CONFIGURACOES');
	
ALTER TABLE public.curso
  ADD COLUMN status VARCHAR;