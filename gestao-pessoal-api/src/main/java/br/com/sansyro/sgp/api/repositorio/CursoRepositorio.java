package br.com.sansyro.sgp.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sansyro.sgp.api.modelo.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>, CursoRepositoryQuery{

}
