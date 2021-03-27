package br.com.sansyro.sgp.api.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sansyro.sgp.api.modelo.Usuario;
import br.com.sansyro.sgp.api.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	/*
	public Page<Usuario> buscarUsuarios(UsuarioDto pUsuario, Pageable pageable){
		return usuarioRepositorio.findAll(pageable);
	}*/
	
	public Usuario salvar(Usuario pUsuario) {
		return usuarioRepositorio.save(pUsuario);
	}

	public Usuario buscarUsuario(Long codigo) {
		return buscarPorId(codigo);
	}
	
	public void remover(Long codigo) {
		usuarioRepositorio.deleteById(codigo);
	}
	
	public Usuario alterar(Long codigo, Usuario pUsuario) {
		Usuario lUsuario = buscarPorId(codigo);
		BeanUtils.copyProperties(pUsuario, lUsuario, "codigo");
		
		return usuarioRepositorio.save(lUsuario);
	}

	private Usuario buscarPorId(Long codigo) {
		Optional<Usuario> lUsuario = usuarioRepositorio.findById(codigo);
		if(!lUsuario.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return lUsuario.get();
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	public Usuario buscarPorEmail(String email) {
		return usuarioRepositorio.findByEmail(email);
	}

}
