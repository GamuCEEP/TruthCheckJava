package service;

import domain.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  @Context
  private HttpServletResponse resp;

  public UserFacadeREST() {
    super(User.class);
  }

  @POST
  @Path("register")
  @Consumes({MediaType.APPLICATION_JSON})
  public void register(User entity) {
    if (entity.getName() == null || entity.getPassword() == null) {
      resp.setStatus(400);
      resp.addHeader(K.ERROR, K.USER_OR_PASSWORD_EMPTY);
      return;
    }
    User u = findByName(entity.getName());

    if (u != null) { // Si existe
      resp.setStatus(418, "Soy una tetera :D");
      resp.addHeader(K.ERROR, K.USER_ALREADY_EXISTS);
      return;
    }

    req.getSession().setAttribute(K.LOGGED_USER, entity);
    super.create(entity);
  }

  @POST
  @Path("login")
  @Consumes({MediaType.APPLICATION_JSON})
  public void login(User entity) {
    if (entity.getName() == null || entity.getPassword() == null) {
      resp.setStatus(400);
      resp.addHeader(K.ERROR, K.USER_OR_PASSWORD_EMPTY);
      return;
    }

    User u = findByName(entity.getName());

    if (u == null || !u.getPassword().equals(entity.getPassword())) {
      resp.setStatus(418, "Soy una tetera :D");
      resp.addHeader(K.ERROR, K.INCORRECT_CREDENTIALS);
      return;
    }

    req.getSession().setAttribute(K.LOGGED_USER, u);
    resp.addHeader(K.USER, entity.getIduser().toString());
  }

  @POST
  @Path("logout")
  public void logout() {
    req.getSession().invalidate();
  }

  @PUT
  @Override
  @Consumes({MediaType.APPLICATION_JSON})
  public void edit(User entity) {
    if (entity.getIduser() == null) {
      resp.setStatus(400);
      resp.setHeader(K.ERROR, K.NO_ID_IN_USER);
      return;
    }

    if (canOperate(entity.getIduser())) {
      super.edit(entity);
    }
  }

  @DELETE
  public void remove() {
    User loggedUser = (User) req.getSession().getAttribute(K.USER);

    if (loggedUser == null) {
      return;
    }

    super.remove(super.find(loggedUser.getIduser()));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public User find(@PathParam("id") Integer id) {
    User u = super.find(id);
    em.detach(u);
    u.setPassword(K.FAKE_PASSWORD);
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
      em.detach(u);
      u.setPassword(K.FAKE_PASSWORD);
    });

    return users;
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_JSON})
  public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    List<User> res = super.findRange(new int[]{from, to});
    res.forEach(u -> {
      em.detach(u);
      u.setPassword(K.FAKE_PASSWORD);
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

}
