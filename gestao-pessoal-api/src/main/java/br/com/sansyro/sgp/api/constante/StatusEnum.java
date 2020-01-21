package br.com.sansyro.sgp.api.constante;

import lombok.Getter;

@Getter
public enum StatusEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");

	private String descricao;
	
	private StatusEnum(String descricao) {
		this.descricao = descricao;
	}

}
