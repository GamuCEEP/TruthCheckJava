package service;

import domain.Effect;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("effect")
public class EffectFacadeREST extends AbstractFacade<Effect> {

  @PersistenceContext(unitName = "TruthCheckJava")
  private EntityManager em;
  
  @Context
  private HttpServletRequest req;

  public EffectFacadeREST() {
    super(Effect.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_JSON})
  public Response create(Effect entity) {
    return super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response edit(@PathParam("id") Integer id, Effect entity) {
    return super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public Response remove(@PathParam("id") Integer id) {
    return super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Effect find(@PathParam("id") Integer id) {
    return super.find(id);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_JSON})
  public List<Effect> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Effect> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String countREST() {
    return String.valueOf(super.count());
  }
  
  
  @GET
  @Path("named/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Effect findByName(@PathParam("name") String name){
    return em.createNamedQuery("Effect.findByName", Effect.class).setParameter("name", name).getSingleResult();
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
    @Override
  protected HttpServletRequest getRequest() {
    return req;
  }

}
