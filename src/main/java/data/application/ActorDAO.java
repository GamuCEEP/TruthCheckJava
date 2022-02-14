package data.application;

import domain.application.Actor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ActorDAO{

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public Actor find(int name) {
    return em.find(Actor.class, name);
  }

  public List<Actor> findAll() {
    return em.createQuery("SELECT u FROM Actor u").getResultList();
  }

  public void persist(Actor resource) {
    em.persist(resource);
  }

  public void merge(Actor resource) {
    em.merge(resource);
  }

  public void remove(Actor resource) {
    em.remove(resource);
  }

  public List<Actor> findText(String text) {
    return em.createQuery("SELECT u FROM Actor u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
  }

}
