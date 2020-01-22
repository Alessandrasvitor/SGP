package br.com.sansyro.sgp.api.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.sansyro.sgp.api.dto.CursoDto;
import br.com.sansyro.sgp.api.modelo.Curso;

public interface CursoRepositoryQuery {

	public Page<Curso> buscarCursos(CursoDto pCurso, Pageable pageable);

}
