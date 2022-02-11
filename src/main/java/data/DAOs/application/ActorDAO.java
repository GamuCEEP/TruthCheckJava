package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Actor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ActorDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public ActorDAO() {
    em = ConnectionManager.getEM();
  }

  public Actor find(int name) {
    return em.find(Actor.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Actor u").getResultList();
  }

  public void persist(Actor... elements) {
    em.getTransaction().begin();
    for (Actor element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Actor... updatedElement) {
    em.getTransaction().begin();
    for (Actor element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Actor... elements) {
    em.getTransaction().begin();
    for (Actor element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }

}
