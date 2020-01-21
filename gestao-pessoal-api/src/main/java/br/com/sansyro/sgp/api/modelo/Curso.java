package br.com.sansyro.sgp.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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

	@NotNull
	@Size(min=3, max=50)
	@Column(name = "nome")
	private String nome;

	@Size(min=3, max=50)
	@Column(name = "conteudo")
	private String conteudo;

	@Size(min=3, max=50)
	@Column(name = "plataforma")
	private String plataforma;

	@Column(name = "nota")
	private Float nota;
	
}
