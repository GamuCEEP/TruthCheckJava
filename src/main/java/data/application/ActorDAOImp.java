package data.application;

import domain.application.Actor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  public Set<Actor> findAll() {
    List<Actor> actors = em.createQuery("SELECT u FROM Actor u").getResultList();
    List<Actor> result = actors != null ? actors : new ArrayList<>();
    return new HashSet<>(result);
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
  public Set<Actor> findText(String text) {
    List<Actor> actors = em.createQuery("SELECT u FROM Actor u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Actor> result = actors != null ? actors : new ArrayList<>();
    return new HashSet<>(result);
  }

}
