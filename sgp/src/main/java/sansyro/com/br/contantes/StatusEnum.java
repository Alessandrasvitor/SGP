package sansyro.com.br.contantes;

public enum StatusEnum {
	
	PENDENTE("Pendente"),
	EM_ANDAMENTO("Em Andamento"),
	CONCLUIDO("Concluído");

	private String descricao;
	
	private StatusEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	} 

}
