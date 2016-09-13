/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pos.cliente;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Luciana
 */
@Path("cliente")
@Stateless
@DataSourceDefinition(
        name = "java:app/jdbc/cliente",
        className = "org.postgresql.Driver",
        url = "jdbc:postgresql://localhost:5432/cliente",
        user = "postgres",
        password = "123")
public class ClienteResource {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(int id) {
        Cliente c = em.find(Cliente.class, id);
        return Response.ok(c).build();
                
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(Cliente cliente) {
        em.persist(cliente);
        return Response.ok(cliente).build();
    }

//    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deletar(@PathParam("id") int id){       
        Cliente c = em.find(Cliente.class, id);
        em.remove(c);
        return Response.ok(c).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Cliente cliente){
        em.merge(cliente);
        return Response.ok(cliente).build();
    }
    
}
