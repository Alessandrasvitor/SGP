package br.com.sansyro.sgp.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instituicao_ensino")
public class Instituicao extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(min=2, max=100)
	@Column(name = "endereco")
	private String endereco;

	@Size(min=3, max=500)
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "relevancia")
	private int relevancia;
	
}
