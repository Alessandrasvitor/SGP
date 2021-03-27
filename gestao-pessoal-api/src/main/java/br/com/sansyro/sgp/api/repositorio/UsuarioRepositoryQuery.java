package br.com.sansyro.sgp.api.repositorio;

import br.com.sansyro.sgp.api.modelo.Usuario;

public interface UsuarioRepositoryQuery {

	Usuario findByEmail(String email);

}
