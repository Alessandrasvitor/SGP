package sansyro.com.br.exemplo;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.PostgreSQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DatabaseTest implements QuarkusTestResourceLifecycleManager {
	
	private static PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("PostgreSQL 10 ");//postgres:11.1

	@Override
	public Map<String, String> start() {
		POSTGRES.start();
		
		Map<String, String> propriedades = new HashMap<>();
		propriedades.put("quarkus.datasource.jdbc.url", POSTGRES.getJdbcUrl());
		propriedades.put("quarkus.datasource.password", POSTGRES.getPassword());
		propriedades.put("quarkus.datasource.username", POSTGRES.getUsername());
		return propriedades ;
	}

	@Override
	public void stop() {
		if(POSTGRES != null) {
			POSTGRES.stop();
		}

	}

}
