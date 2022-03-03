package service;

import java.util.HashMap;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("util")
public class UtilFacadeREST {

  @GET
  @Path("resourceTypes")
  @Produces({MediaType.APPLICATION_JSON})
  public HashMap getResourceTypes(){
    
    HashMap res = new HashMap();
    res.put("Actor", "actor");
    res.put("Item", "item");
    res.put("Escenario", "stage");
    res.put("Interacción", "interaction");
    res.put("Effecto", "effect");
    res.put("Evento", "event");
    res.put("Mapa", "map");
    
    return res;    
  }
}
