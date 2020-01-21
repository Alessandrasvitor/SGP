package br.com.sansyro.sgp.api.constante;

import lombok.Getter;

@Getter
public enum SituacaoEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");

	private String descricao;
	
	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}

}
