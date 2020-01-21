package br.com.sansyro.sgp.api.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.br.ajenterprise.api.dto.CursoDto;
import com.br.ajenterprise.api.modelo.Curso;
import com.br.ajenterprise.api.modelo.Curso_;

@SuppressWarnings(value = {"rawtypes", "unchecked"})
public class CursoRepositoryImpl implements CursoRepositoryQuery{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public Page<Curso> buscarCursos(CursoDto pCurso, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Curso> criteria = builder.createQuery(Curso.class);
		Root<Curso> root = criteria.from(Curso.class);
		
		Predicate[] predicates = criarFiltrosPesquisa(pCurso, builder, root);
		
		criteria.where( builder.and((javax.persistence.criteria.Predicate[]) predicates));
		
		TypedQuery<Curso> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(pCurso));
	}

	private Predicate[] criarFiltrosPesquisa(CursoDto pCurso, CriteriaBuilder builder, Root<Curso> root) {
		List<Predicate> predicates = new ArrayList();
		
		if(StringUtils.isNotEmpty(pCurso.getNome())) {
			predicates.add(	(Predicate) builder.like(builder.upper(root.get(Curso_.nome)) , "%"+pCurso.getNome().toUpperCase()+"%"));
		}
		
		if(StringUtils.isNotEmpty(pCurso.getPlataforma())) {
			predicates.add(	(Predicate) builder.like(builder.upper(root.get(Curso_.plataforma)) , "%"+pCurso.getPlataforma().toUpperCase()+"%"));
		}
		
		if(StringUtils.isNotEmpty(pCurso.getConteudo())) {
			predicates.add(	(Predicate) builder.like(builder.upper(root.get(Curso_.conteudo)) , "%"+pCurso.getConteudo().toUpperCase()+"%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesPaginacao(TypedQuery<Curso> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPagina= pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtual * totalRegistrosPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPagina);
	}

	private Long total(CursoDto pCurso) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Curso> root = criteria.from(Curso.class);

		Predicate[] predicates = criarFiltrosPesquisa(pCurso, builder, root);
		
		criteria.where( builder.and((javax.persistence.criteria.Predicate[]) predicates));
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
