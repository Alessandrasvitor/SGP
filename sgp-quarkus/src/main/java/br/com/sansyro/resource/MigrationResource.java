package br.com.sansyro.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.flywaydb.core.Flyway;

//@Authorize
@Path("/migrateDados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MigrationResource {
	
    @Inject
    Flyway flyway;
    
    @GET
    @Path("/check")
    public Response ckeck() {
    	flyway.migrate();
    	return Response.ok().build();
    }
    
    @GET
    @Path("/clean")
    public Response clean() {
    	flyway.clean(); 
    	return Response.ok().build();
    }
}
