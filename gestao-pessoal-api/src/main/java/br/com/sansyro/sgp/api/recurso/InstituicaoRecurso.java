package br.com.sansyro.sgp.api.recurso;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sansyro.sgp.api.modelo.Instituicao;
import br.com.sansyro.sgp.api.servico.InstituicaoServico;

@CrossOrigin
@RestController
@RequestMapping("/instituicoes")
public class InstituicaoRecurso implements CrudRecurso<Instituicao>{
	
	@Autowired
	private InstituicaoServico instituicaoServico;

	@GetMapping
	@Override
	public List<Instituicao> pesquisarTodos() {
		return instituicaoServico.listarInstituicoes();
	}

//	@GetMapping
//	public Page<Instituicao> buscarInstituicoes(InstituicaoDto pInstituicao, Pageable pageable){
//		return instituicaoServico.buscarInstituicoes(pInstituicao, pageable);
//	}
	
	@PostMapping
	@Override
	public ResponseEntity<Instituicao> salvar(@Valid @RequestBody Instituicao pInstituicao, HttpServletResponse pResponse) {
		Instituicao lInstituicao = instituicaoServico.salvar(pInstituicao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(lInstituicao.getCodigo()).toUri();
		pResponse.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(lInstituicao);
	}
	
	@GetMapping("/{codigo}")
	@Override
	public ResponseEntity<Instituicao> pesquisarPorId(@PathVariable Long codigo) {
		Instituicao lInstituicao = instituicaoServico.buscarInstituicao(codigo);
		
		return ResponseEntity.ok(lInstituicao);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		instituicaoServico.remover(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Instituicao> alterar(@PathVariable Long codigo, @Valid @RequestBody Instituicao pInstituicao) {
		Instituicao lInstituicao = instituicaoServico.alterar(codigo, pInstituicao);
		return ResponseEntity.ok(lInstituicao);
	}

}
