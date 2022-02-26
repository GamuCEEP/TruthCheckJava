package service;

import domain.Trigger;
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


@Stateless
@Path("trigger")
public class TriggerFacadeREST extends AbstractFacade<Trigger> {

  @PersistenceContext(unitName = "TruthCheckJava")
  private EntityManager em;
  
  @Context
  private HttpServletRequest req;

  public TriggerFacadeREST() {
    super(Trigger.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_JSON})
  public void create(Trigger entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") Integer id, Trigger entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") Integer id) {
    super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Trigger find(@PathParam("id") Integer id) {
    return super.find(id);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_JSON})
  public List<Trigger> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Trigger> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String countREST() {
    return String.valueOf(super.count());
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
