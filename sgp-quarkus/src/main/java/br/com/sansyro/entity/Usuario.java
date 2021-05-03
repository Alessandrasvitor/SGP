package br.com.sansyro.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.sansyro.dto.UsuarioDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario extends PanacheEntity {
	
	@Column(name = "nome")
	private String nome;
	private String senha;
	private String email;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_criacao")
	private Date dataCriacao;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	private Date dataAlteracao;
	
	private String perfil;
	private String token;

	public Usuario() {
	}

	public Usuario(UsuarioDTO usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil();
		this.senha = usuario.getSenha();
	}

	public void atualizar(Usuario usuario) {
		this.nome = usuario.getNome();
		this.perfil = usuario.getPerfil();
		this.persist();
	}

	public void atualizarSenha(String senha) {
		this.senha = senha;
		this.persist();
	}

	public static Usuario buscarPorEmailESenha(String email, String senha) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		params.put("senha", senha);
		return find("senha = :senha and email = :email", params).firstResult();
	}

}
