package service;

import domain.Stats;
import domain.StatsPK;
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
import javax.ws.rs.core.PathSegment;


@Stateless
@Path("stats")
public class StatsFacadeREST extends AbstractFacade<Stats> {

  @PersistenceContext(unitName = "TruthCheckJava")
  private EntityManager em;
  
  @Context
  private HttpServletRequest req;

  private StatsPK getPrimaryKey(PathSegment pathSegment) {
    /*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;statkey=statkeyValue;actorId=actorIdValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    domain.StatsPK key = new domain.StatsPK();
    javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
    java.util.List<String> statkey = map.get("statkey");
    if (statkey != null && !statkey.isEmpty()) {
      key.setStatkey(statkey.get(0));
    }
    java.util.List<String> actorId = map.get("actorId");
    if (actorId != null && !actorId.isEmpty()) {
      key.setActorId(new java.lang.Integer(actorId.get(0)));
    }
    return key;
  }

  public StatsFacadeREST() {
    super(Stats.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_JSON})
  public void create(Stats entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") PathSegment id, Stats entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") PathSegment id) {
    domain.StatsPK key = getPrimaryKey(id);
    super.remove(super.find(key));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Stats find(@PathParam("id") PathSegment id) {
    domain.StatsPK key = getPrimaryKey(id);
    return super.find(key);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_JSON})
  public List<Stats> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<Stats> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
