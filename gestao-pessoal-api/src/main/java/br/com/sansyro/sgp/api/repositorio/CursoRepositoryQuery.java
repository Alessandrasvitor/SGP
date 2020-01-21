package br.com.sansyro.sgp.api.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.ajenterprise.api.dto.CursoDto;
import com.br.ajenterprise.api.modelo.Curso;

public interface CursoRepositoryQuery {

	public Page<Curso> buscarCursos(CursoDto pCurso, Pageable pageable);

}
