package service;

import domain.Actor;
import domain.Effect;
import domain.Event;
import domain.Interaction;
import domain.Item;
import domain.Map;
import domain.Stage;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Path("user")
public class UserFacadeREST extends AbstractFacade<User> {

  @PersistenceContext(unitName = "TruthCheckJava")
  private EntityManager em;

  @Context
  private HttpServletRequest req;

  public UserFacadeREST() {
    super(User.class);
  }

  private User findUser(User entity) {
    if (entity.getName() == null || entity.getPassword() == null) {
      return null;
    }
    return findByName(entity.getName());
  }

  @POST
  @Path("register")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response register(User entity) {
    User u = findUser(entity);

    if (u != null) { // Si existe
      return Response
              .status(418, "Soy una tetera :D")
              .header(K.ERROR, K.USER_ALREADY_EXISTS)
              .build();
    }

    super.create(entity);
    return login(entity);
  }

  @POST
  @Path("login")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response login(User entity) {
    User u = findUser(entity);

    if (u == null || !u.getPassword().equals(entity.getPassword())) {
      return Response
              .status(418, "Soy una tetera :D")
              .header(K.ERROR, K.INCORRECT_CREDENTIALS)
              .build();
    }

    hidePassword(u);

    req.getSession().setAttribute(K.LOGGED_USER, u);
    return Response.accepted().build();
  }

  @GET
  @Path("logged")
  @Produces({MediaType.APPLICATION_JSON})
  public User logged() {
    System.out.println("Quien esta logueado??");
    User u = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (u == null) {
      u = new User();
      u.setName("");
      System.out.println("Nadie");
      return u;
    }
    System.out.println(u.getName());
    return u;
  }

  @GET
  @Path("logout")
  public void logout() {
    req.getSession().invalidate();
  }

  @PUT
  @Override
  @Consumes({MediaType.APPLICATION_JSON})
  public Response edit(User entity) {
    if (entity.getId() == null) {
      return Response
              .status(418, "Soy una tetera :D")
              .header(K.ERROR, K.NO_ID_IN_USER)
              .build();
    }

    if (canOperate(entity.getId())) {
      super.edit(entity);
    }
    return Response.accepted().build();
  }

  @DELETE
  public void remove() {
    User loggedUser = (User) req.getSession().getAttribute(K.USER);

    if (loggedUser == null) {
      return;
    }

    super.remove(super.find(loggedUser.getId()));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public User find(@PathParam("id") Integer id) {
    User u = super.find(id);
    hidePassword(u);
    return u;
  }

  private User findByName(String name) {
    TypedQuery<User> q = em.createNamedQuery("User.findByName", User.class);
    q.setParameter("name", name);
    List<User> ul = q.getResultList();
    User u = ul.isEmpty() ? null : ul.get(0);
    return u;
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_JSON})
  public List<User> findAll() {
    List<User> users = super.findAll();

    users.forEach(u -> {
      hidePassword(u);
    });

    return users;
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    List<User> res = super.findRange(new int[]{from, to});
    res.forEach(u -> {
      hidePassword(u);
    });
    return res;
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

  private User hidePassword(User u) {
    em.detach(u);
    u.setPassword(K.FAKE_PASSWORD);
    return u;
  }

  @POST
  @Path("item")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addItemToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Item e = em.find(Item.class, id);
    logged.getItemCollection().add(e);
  }

  @POST
  @Path("actor")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addActorToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Actor e = em.find(Actor.class, id);
    logged.getActorCollection().add(e);
  }

  @POST
  @Path("stage")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addStageToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Stage e = em.find(Stage.class, id);
    logged.getStageCollection().add(e);
  }

  @POST
  @Path("interaction")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addInteractionToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Interaction e = em.find(Interaction.class,id);
    logged.getInteractionCollection().add(e);
  }

  @POST
  @Path("event")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addEventToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Event e = em.find(Event.class, id);
    logged.getEventCollection().add(e);
  }

  @POST
  @Path("effect")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addEffectToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Effect e = em.find(Effect.class, id);
    logged.getEffectCollection().add(e);
  }

  @POST
  @Path("map")
  @Consumes({MediaType.TEXT_PLAIN})
  public void addMapToLibrary(int id) {
    User logged = (User) req.getSession().getAttribute(K.LOGGED_USER);
    if (logged == null) {
      return;
    }
    Map e = em.find(Map.class, id);
    logged.getMapCollection().add(e);
  }

}
