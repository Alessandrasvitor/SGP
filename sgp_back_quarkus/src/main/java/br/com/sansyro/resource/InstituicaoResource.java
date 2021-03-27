package br.com.sansyro.resource;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.sansyro.entity.Instituicao;
import io.quarkus.panache.common.Sort;

@Path("/instituicao")
@SuppressWarnings("static-access")
public class InstituicaoResource {
	
	@GET
	public Response bustarTodas() {
		return Response.ok().entity(Instituicao.listAll(Sort.by("nome"))).build();
	}
	
	@POST
    @Transactional
	public Response salvar(Instituicao instituicao) {
		instituicao.persist();
		return Response.ok().entity(instituicao).build();
	}
	
	@PUT
    @Transactional
    @Path("/{id}")
	public Response alterar(@PathParam("id") Long id, Instituicao instituicao) {
		Instituicao instituicaoAlterada = instituicao.findById(id);
		instituicaoAlterada.atualizar(instituicao);
		return Response.ok().entity(instituicaoAlterada).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")	
	public Response deletar(@PathParam("id") Long id) {
		Instituicao instituicao = Instituicao.findById(id);
		instituicao.delete();
		return Response.ok().build();
	}

}
