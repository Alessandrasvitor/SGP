package br.com.sansyro.sgp.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dominio_fixo")
public class DominioFixo {
		
	@Id
	@NotNull
	private Long codigo;

	@NotNull
	@Column(name = "descricao")
	private String descricao;

}
