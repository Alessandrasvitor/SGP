package br.com.sansyro.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.sansyro.constante.StatusEnum;
import br.com.sansyro.dto.CursoDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="curso")
public class Curso extends PanacheEntity {
	
	@Column(name = "nome")
	private String nome;
	private String descricao;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_criacao")
	private Date dataCriacao;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	private Date dataAlteracao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "intituicao_ensino_id", referencedColumnName = "id")
	private Instituicao instituicaoEnsino;
	
	private float nota;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	private Boolean finalizado;

	public Curso() {
	}

	public void atualizar(CursoDTO curso) {
		this.nome =curso.getNome();
		this.descricao = curso.getDescricao();
		this.instituicaoEnsino = curso.getInstituicaoEnsino();
		this.persist();
		
	}

}
