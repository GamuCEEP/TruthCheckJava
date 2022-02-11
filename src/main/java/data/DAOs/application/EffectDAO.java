package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Effect;
import domain.beans.application.Effect;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EffectDAO {
 
  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public EffectDAO() {
    em = ConnectionManager.getEM();
  }

  public Effect find(int name) {
    return em.find(Effect.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Effect u").getResultList();
  }

  public void persist(Effect... elements) {
    em.getTransaction().begin();
    for (Effect element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Effect... updatedElement) {
    em.getTransaction().begin();
    for (Effect element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Effect... elements) {
    em.getTransaction().begin();
    for (Effect element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
