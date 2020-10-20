
ALTER TABLE instituicao_ensino ADD nome varchar(255) NOT NULL;

ALTER TABLE instituicao_ensino
  ADD UNIQUE (nome);