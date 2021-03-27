package sansyro.com.br.exemplo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="produto")
public class Produto extends PanacheEntity {

	private String nome;
	private Double valor;
	@CreationTimestamp
	private Date dataCriacao;
	@UpdateTimestamp
	private Date dataAlteracao;

	public Produto() {
	}

	public Produto(ProdutoDTO produto) {
		this.nome = produto.getNome();
		this.valor = produto.getValor();
	}

}
