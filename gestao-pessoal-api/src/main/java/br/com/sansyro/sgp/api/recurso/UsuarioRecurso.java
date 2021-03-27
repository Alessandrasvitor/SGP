package br.com.sansyro.sgp.api.recurso;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sansyro.sgp.api.modelo.Usuario;
import br.com.sansyro.sgp.api.modelo.dto.UsuarioDTO;
import br.com.sansyro.sgp.api.servico.UsuarioServico;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@GetMapping
	public List<Usuario> buscarUsuarios(){
		return usuarioServico.listarUsuarios();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario pUsuario, HttpServletResponse pResponse) {
		Usuario lUsuario = usuarioServico.salvar(pUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(lUsuario.getCodigo()).toUri();
		pResponse.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(lUsuario);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> alterar(@PathVariable Long codigo, @Valid @RequestBody Usuario pUsuario) {
		Usuario lUsuario = usuarioServico.salvar(pUsuario);
		return ResponseEntity.ok(lUsuario);
	}
	
	@PutMapping("/email")
	public ResponseEntity<Usuario> logar(@RequestBody UsuarioDTO pUsuario) {
		Usuario lUsuario = usuarioServico.buscarPorEmail(pUsuario.getEmail());
		return ResponseEntity.ok(lUsuario);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarUsuario(@PathVariable Long codigo) {
		Usuario lUsuario = usuarioServico.buscarUsuario(codigo);
		
		return lUsuario != null ? ResponseEntity.ok(lUsuario) : ResponseEntity.notFound().build() ;
	}

}
