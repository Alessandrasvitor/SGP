package br.com.sansyro.dto;

import br.com.sansyro.entity.Instituicao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDTO {
	
	private String nome;
	private String descricao;
	private Instituicao instituicaoEnsino;

}
