package br.com.sansyro.sgp.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ajenterprise.api.modelo.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>, CursoRepositoryQuery{

}
