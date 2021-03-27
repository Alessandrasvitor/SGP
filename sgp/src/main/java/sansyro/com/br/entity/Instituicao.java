package sansyro.com.br.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import lombok.Getter;
import lombok.Setter;

import sansyro.com.br.contantes.StatusEnum;
import sansyro.com.br.dto.CursoDTO;

@Getter
@Setter
@Entity
@Table(name="instituicao_ensino")
public class Instituicao extends PanacheEntity {

	@Column(name = "nome")
	private String nome;
	private String endereco;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_criacao")
	private Date dataCriacao;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	private Date dataAlteracao;
	private Integer avaliacao;

	public Instituicao() {
	}

	public void atualizar(Instituicao instituicao) {
		this.nome = instituicao.getNome();
		this.endereco = instituicao.getEndereco();
		this.avaliacao = instituicao.getAvaliacao();
		this.persist();
		
	}
	

}
