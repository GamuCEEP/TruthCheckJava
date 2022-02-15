package data.application;

import domain.application.Actor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ActorDAOImp implements ActorDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Actor find(int name) {
    return em.find(Actor.class, name);
  }

  @Override
  public List<Actor> findAll() {
    List<Actor> actors = em.createQuery("SELECT u FROM Actor u").getResultList();
    return actors != null ? actors : new ArrayList<>();
  }

  @Override
  public void persist(Actor resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Actor resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Actor resource) {
    em.remove(resource);
  }

  @Override
  public List<Actor> findText(String text) {
    List<Actor> actors = em.createQuery("SELECT u FROM Actor u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return actors != null ? actors : new ArrayList<>();
  }

}
