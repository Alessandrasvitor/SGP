package br.com.sansyro.sgp.api.dto;

import br.com.sansyro.sgp.api.modelo.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDto {
	private String nome;
	private String conteudo;
	
	public CursoDto() {
	}

	public CursoDto(Curso pCurso) {
		this.nome = pCurso.getNome();
		this.conteudo = pCurso.getConteudo();
	}

}
