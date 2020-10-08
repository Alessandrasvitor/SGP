package br.com.sansyro.sgp.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(min=3, max=50)
	@Column(name = "conteudo")
	private String conteudo;

	@JoinColumn(name = "instituicao_id", referencedColumnName = "codigo")
	@ManyToOne(fetch = FetchType.LAZY)
	private Instituicao instituicao;

	@Column(name = "nota")
	private Float nota;
	
}
