package br.com.sansyro.sgp.api.constante;

import lombok.Getter;

@Getter
public enum TelaAcessoEnum {
	
	CONFIGURACOES("Configurações"),
	CURSOS("Cursos"),
	CALENDARIOS("Calendário"),
	FINANCAS("Finanças"),
	DOCUMENTOS("Documentos"),
	INSTITUICOES("Instituições");

	private String descricao;
	
	private TelaAcessoEnum(String descricao) {
		this.descricao = descricao;
	}
	

}
