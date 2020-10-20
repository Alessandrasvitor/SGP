package br.com.sansyro.sgp.api.recurso;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

@SuppressWarnings("rawtypes")
public interface CrudRecurso<E> {

	List pesquisarTodos();

	ResponseEntity<E> salvar(E entity, HttpServletResponse response);

	ResponseEntity<E> pesquisarPorId(Long codigo);

}
