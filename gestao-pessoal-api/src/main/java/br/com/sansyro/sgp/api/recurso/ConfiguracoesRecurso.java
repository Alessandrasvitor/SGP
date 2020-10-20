package br.com.sansyro.sgp.api.recurso;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sansyro.sgp.api.modelo.Despesa;
import br.com.sansyro.sgp.api.repositorio.DespesaRepositoryQuery;

@CrossOrigin
@RestController
@RequestMapping("/config")
public class ConfiguracoesRecurso {
	
	@Autowired
	private DespesaRepositoryQuery DespesaRepository;
	
	@GetMapping
	public List<Despesa> listar() {
		return DespesaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Despesa> buscar(@PathVariable Long id) {
		Optional<Despesa> despesa = DespesaRepository.findById(id);
		if(!despesa.isPresent()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(despesa.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Despesa adicionar(@Validated @RequestBody Despesa despesa) {
		return DespesaRepository.save(despesa);
	}

}
