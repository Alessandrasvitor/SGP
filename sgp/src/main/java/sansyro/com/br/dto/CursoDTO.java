package sansyro.com.br.dto;

import lombok.Getter;
import lombok.Setter;
import sansyro.com.br.entity.Instituicao;

@Getter
@Setter
public class CursoDTO {
	
	private String nome;
	private String descricao;
	private Instituicao instituicaoEnsino;
	
}
