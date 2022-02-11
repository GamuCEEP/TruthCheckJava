package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Interaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class InteractionDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public InteractionDAO() {
    em = ConnectionManager.getEM();
  }

  public Interaction find(int name) {
    return em.find(Interaction.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Interaction u").getResultList();
  }

  public void persist(Interaction... elements) {
    em.getTransaction().begin();
    for (Interaction element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Interaction... updatedElement) {
    em.getTransaction().begin();
    for (Interaction element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Interaction... elements) {
    em.getTransaction().begin();
    for (Interaction element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
