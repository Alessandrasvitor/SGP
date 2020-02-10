package br.com.sansyro.sgp.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sansyro.sgp.api.modelo.Despesa;

public interface DespesaRepositoryQuery extends JpaRepository<Despesa, Long> {

}
