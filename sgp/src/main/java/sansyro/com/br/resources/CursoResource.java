package sansyro.com.br.resources;

import java.util.Date;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import io.quarkus.panache.common.Sort;
import sansyro.com.br.contantes.StatusEnum;
import sansyro.com.br.dto.CursoDTO;
import sansyro.com.br.entity.Curso;

@Path("/curso")
public class CursoResource {
	
	@GET
	public Response bustarTodos() {
		return Response.ok().entity(Curso.listAll(Sort.by("nome"))).build();
	}
	
	@POST
    @Transactional
	public Response salvar(Curso curso) {
		curso.setStatus(StatusEnum.PENDENTE);
		curso.persist();
		return Response.ok().entity(curso).build();
	}
	
	@PUT
    @Transactional
    @Path("/{id}")
	public Response alterar(@PathParam("id") Long id, CursoDTO curso) {
		Curso cursoAlterado = Curso.findById(id);
		cursoAlterado.atualizar(curso);
		return Response.ok().entity(cursoAlterado).build();
	}
	
	@PUT
    @Transactional
    @Path("/concluir/{id}")
	public Response concluir(@PathParam("id") Long id, float nota) {
		Curso cursoAlterado = Curso.findById(id);
		cursoAlterado.setStatus(StatusEnum.CONCLUIDO);
		cursoAlterado.setDataFim(new Date());
		cursoAlterado.setFinalizado(Boolean.TRUE);
		cursoAlterado.setNota(nota);
		cursoAlterado.persist();
		return Response.ok().entity(cursoAlterado).build();
	}
	
	@PUT
    @Transactional
    @Path("/avancar/{id}")
	public Response iniciarCurso(@PathParam("id") Long id) {
		Curso cursoAlterado = Curso.findById(id);
		cursoAlterado.setStatus(StatusEnum.EM_ANDAMENTO);
		cursoAlterado.setDataInicio(new Date());
		cursoAlterado.persist();
		return Response.ok().entity(cursoAlterado).build();
	}
	
	@PUT
    @Transactional
    @Path("/reiniciar/{id}")
	public Response reiniciarCurso(@PathParam("id") Long id) {
		Curso cursoAlterado = Curso.findById(id);
		cursoAlterado.setStatus(StatusEnum.PENDENTE);
		cursoAlterado.persist();
		return Response.ok().entity(cursoAlterado).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")	
	public Response deletar(@PathParam("id") Long id) {
		Curso curso = Curso.findById(id);
		curso.delete();
		return Response.ok().build();
	}

}
