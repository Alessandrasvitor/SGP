package br.com.sansyro.sgp.api.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="despesa")
public class Despesa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long id;
	
	@Column
	@NotNull
	@NotEmpty
	private String descricao;

	@NotNull
	@Column(name = "valor_pagar")
	private BigDecimal valorPagar;
	
	@Column(name =  "valor_pago")
	private BigDecimal valorPago;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
