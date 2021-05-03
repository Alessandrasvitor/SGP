package br.com.sansyro.resource;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.sansyro.dto.UsuarioDTO;
import br.com.sansyro.entity.Usuario;
import br.com.sansyro.util.CriptografiaUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.quarkus.panache.common.Sort;

@Path("/usuario")
public class UsuarioResource {

	private final Key CHAVE = Keys.hmacShaKeyFor(
	        "7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
	        .getBytes(StandardCharsets.UTF_8));
	
	@GET
	public Response bustarTodos() {
		return Response.ok().entity(Usuario.listAll(Sort.by("nome"))).build();
	}
	
	@POST
    @Transactional
	public Response salvar(UsuarioDTO usuario) {
		Usuario usuarioNovo = new Usuario();
		usuarioNovo.setNome(usuario.getNome());
		usuarioNovo.setEmail(usuario.getEmail());
		usuarioNovo.setSenha(CriptografiaUtil.criptografarSHA256(usuario.getSenha()));
		usuarioNovo.persist();
		return Response.ok().entity(usuarioNovo).build();
	}
	
	@PUT
    @Transactional
    @Path("/{id}")
	public Response alterar(@PathParam("id") Long id, Usuario usuario) {
		Usuario usuarioAlterado = Usuario.findById(id);
		usuarioAlterado.atualizar(usuario);
		return Response.ok().entity(usuarioAlterado).build();
	}
	
	@PUT
    @Transactional
    @Path("/logar")
	public Response logar(UsuarioDTO usuario) {
		Usuario usuarioLogado = Usuario.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		
		try {
			if (usuarioLogado != null) {
				String jwtToken = Jwts.builder().setSubject(usuarioLogado.getEmail())
						.setIssuedAt(new Date())
						.setExpiration(Date
								.from(LocalDateTime.now().plusHours(2L).atZone(ZoneId.systemDefault()).toInstant()))
						.signWith(CHAVE).compact();
				usuarioLogado.setToken(jwtToken);
				usuarioLogado.persist();
				return Response.status(Response.Status.OK).entity(usuarioLogado).build();
			} else
				return Response.status(Response.Status.UNAUTHORIZED).entity("Usuário e/ou senha inválidos").build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	@PUT
    @Transactional
    @Path("/senha/{id}")
	public Response alterarSenha(@PathParam("id") Long id, Usuario usuario) {
		Usuario usuarioAlterado = Usuario.findById(id);
		usuarioAlterado.atualizarSenha(usuario.getSenha());
		return Response.ok().entity(usuarioAlterado).build();
	}
	
	@DELETE
    @Transactional
    @Path("/{id}")	
	public Response deletar(@PathParam("id") Long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		return Response.ok().build();
	}

}
