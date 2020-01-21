package br.com.sansyro.sgp.api.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ extends com.br.ajenterprise.api.modelo.Entidade_ {

	public static volatile SingularAttribute<Curso, String> conteudo;
	public static volatile SingularAttribute<Curso, String> plataforma;
	public static volatile SingularAttribute<Curso, String> nome;
	public static volatile SingularAttribute<Curso, Float> nota;

	public static final String CONTEUDO = "conteudo";
	public static final String PLATAFORMA = "plataforma";
	public static final String NOME = "nome";
	public static final String NOTA = "nota";

}

