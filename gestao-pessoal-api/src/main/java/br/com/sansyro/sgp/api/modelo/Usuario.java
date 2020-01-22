package br.com.sansyro.sgp.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sansyro.sgp.api.constante.PerfilEnum;
import br.com.sansyro.sgp.api.constante.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min=3, max=50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(min=3, max=20)
	@Column(name = "login")
	private String login;

	@Size(min=3, max=30)
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(min=4, max=10)
	@Column(name = "senha")
	private String senha;

	@NotNull
	@Column(name = "perfil")
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	@NotNull
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

}
