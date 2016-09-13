/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pos.cliente;

 
/**
 *
 * @author Luciana
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class App {

    public static void main(String[] args) {
        
        String url = ("http://localhost:8080/Cliente/api");
        Client client = ClientBuilder.newClient();
        
                WebTarget api = client.target(url);
//        Response get = api.path("cliente")
//                .request(MediaType.APPLICATION_XML).get();
                Cliente cliente = new Cliente("Luciana", "12345", "1243455");
//        
        Response post = api.path("cliente")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(cliente));
        

        System.out.println(post.readEntity(String.class));
    }

       
        
    }


