package br.com.sansyro.sgp.api.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.sansyro.sgp.api.modelo.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery{

	@PersistenceContext
	EntityManager manager;

	@Override
	public Usuario findByEmail(String email) {
		Query query = manager.createNamedQuery("SELECT u FROM Usuario u WHERE u.email = :email").setParameter("email", email);
		return (Usuario) query.getSingleResult();
	}


}
