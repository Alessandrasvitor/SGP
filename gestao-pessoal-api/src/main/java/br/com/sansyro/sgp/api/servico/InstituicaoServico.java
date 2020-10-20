package br.com.sansyro.sgp.api.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sansyro.sgp.api.dto.CursoDto;
import br.com.sansyro.sgp.api.modelo.Instituicao;
import br.com.sansyro.sgp.api.repositorio.InstituicaoRepositorio;

@Service
public class InstituicaoServico {
	
	@Autowired
	private InstituicaoRepositorio instituicaoRepositorio;
	
	public Page<Instituicao> buscarCursos(CursoDto pInstituicao, Pageable pageable){
		return instituicaoRepositorio.findAll(pageable);
	}
	
	public Instituicao salvar(Instituicao pInstituicao) {
		return instituicaoRepositorio.save(pInstituicao);
	}

	public Instituicao buscarInstituicao(Long codigo) {
		return buscarPorId(codigo);
	}
	
	public void remover(Long codigo) {
		instituicaoRepositorio.deleteById(codigo);
	}
	
	public Instituicao alterar(Long codigo, Instituicao pInstituicao) {
		Instituicao lInstituicao = buscarPorId(codigo);
		BeanUtils.copyProperties(pInstituicao, lInstituicao, "codigo");
		instituicaoRepositorio.save(lInstituicao);
		
		return instituicaoRepositorio.save(lInstituicao);
	}

	private Instituicao buscarPorId(Long codigo) {
		Optional<Instituicao> lInstituicao = instituicaoRepositorio.findById(codigo);
		if(!lInstituicao.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return lInstituicao.get();
	}

	public List<Instituicao> listarInstituicoes() {
		return instituicaoRepositorio.findAll();
	}

}
