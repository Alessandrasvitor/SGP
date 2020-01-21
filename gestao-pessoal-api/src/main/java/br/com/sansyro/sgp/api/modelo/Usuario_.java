package br.com.sansyro.sgp.api.modelo;

import com.br.ajenterprise.api.constante.PerfilEnum;
import com.br.ajenterprise.api.constante.StatusEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ extends com.br.ajenterprise.api.modelo.Entidade_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> login;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, PerfilEnum> perfil;
	public static volatile SingularAttribute<Usuario, StatusEnum> status;

	public static final String SENHA = "senha";
	public static final String NOME = "nome";
	public static final String LOGIN = "login";
	public static final String EMAIL = "email";
	public static final String PERFIL = "perfil";
	public static final String STATUS = "status";

}

