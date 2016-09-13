/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.microservicos.webservice;

import ifpb.ads.pos.microservicos.dao.ProdutoDao;
import ifpb.ads.pos.microservicos.entity.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kaique Candido
 */
@Path("produto")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ServiceProduto {

    @EJB
    private ProdutoDao pd;

    @GET
    public Response listarProdutos() {
        List<Produto> listar = pd.listar();
        GenericEntity<List<Produto>> gLista = new GenericEntity<List<Produto>>(listar) {
        };
        return Response.ok(gLista).build();
    }

    @GET
    @Path("{id}")
    public Response getProduto(@PathParam("id") long id) {
        Produto produto = pd.buscar(id);
        return Response.ok(produto).build();
    }

    @PUT
    public Response atualizar(Produto produto) {
        return Response.ok(pd.atualizar(produto)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") long id) {
        return Response.ok(pd.remover(id)).build();
    }

    @POST
    public Response cadastrar(Produto produto) {
        return Response.ok(pd.salvar(produto)).build();
    }

}
