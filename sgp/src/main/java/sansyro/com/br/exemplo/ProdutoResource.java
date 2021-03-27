package sansyro.com.br.exemplo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	@GET
	public List<Produto> listar() {
		return Produto.listAll();
	}
	
	@POST
	@Transactional
	public Response criar(ProdutoDTO produto) {
		Produto produtoNovo = new Produto(produto);
		produtoNovo.persist();
		return Response.ok().entity(produtoNovo).build();
		
	}
	
	@PUT
	@Transactional
	@Path("/{id}")
	public Produto alterar(@PathParam("id") Long id,  ProdutoDTO produto) throws NoContentException {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		if(produtoOp.isPresent()) {
			Produto produtoNovo = produtoOp.get();
			produtoNovo.setNome(produto.getNome());
			produtoNovo.setValor(produto.getValor());
			produtoNovo.persist();
			return produtoNovo;			
		}
		
		throw new NoContentException("Produto não encontrado na base de dados!");
		
	}
	
	@DELETE
	@Transactional
	@Path("/{id}")
	public Response remover(@PathParam("id") Long id) throws NoContentException {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		produtoOp.ifPresentOrElse(Produto::delete, () -> {} );
		
		return Response.ok().build();
		
	}

}
