package br.com.sansyro.sgp.api.servico;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.ajenterprise.api.dto.CursoDto;
import com.br.ajenterprise.api.modelo.Curso;
import com.br.ajenterprise.api.repositorio.CursoRepositorio;

@Service
public class CursoServico {
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	public Page<Curso> buscarCursos(CursoDto pCurso, Pageable pageable){
		return cursoRepositorio.buscarCursos( pCurso, pageable);
	}
	
	public Curso salvar(Curso pCurso) {
		return cursoRepositorio.save(pCurso);
	}

	public Curso buscarCurso(Long codigo) {
		return buscarPorId(codigo);
	}
	
	public void remover(Long codigo) {
		cursoRepositorio.deleteById(codigo);
	}
	
	public Curso alterar(Long codigo, Curso pCurso) {
		Curso lCurso = buscarPorId(codigo);
		BeanUtils.copyProperties(pCurso, lCurso, "codigo");
		cursoRepositorio.save(lCurso);
		
		return cursoRepositorio.save(lCurso);
	}

	private Curso buscarPorId(Long codigo) {
		Optional<Curso> lCurso = cursoRepositorio.findById(codigo);
		if(!lCurso.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return lCurso.get();
	}

	public Curso lancarNota(Long codigo, Float nota) {
		Curso lCurso = buscarPorId(codigo);
		lCurso.setNota(nota);
		return lCurso;
	}
	
	
}
