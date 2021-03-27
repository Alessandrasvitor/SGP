package br.com.sansyro.sgp.api.modelo;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sansyro.sgp.api.constante.PerfilEnum;
import br.com.sansyro.sgp.api.constante.TelaAcessoEnum;
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
	@Size(min=3, max=30)
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "senha")
	private String senha;

	@NotNull
	@Column(name = "perfil")
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	private boolean status;

	@ElementCollection(targetClass = TelaAcessoEnum.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "permissao",
	           joinColumns=@JoinColumn(name="usuario_id"))
	@Column(name = "tela_acesso")
	private Set<TelaAcessoEnum> permissoes;

}
