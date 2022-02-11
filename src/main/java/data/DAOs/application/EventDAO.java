package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Event;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EventDAO {

 
  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public EventDAO() {
    em = ConnectionManager.getEM();
  }

  public Event find(int name) {
    return em.find(Event.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Event u").getResultList();
  }

  public void persist(Event... elements) {
    em.getTransaction().begin();
    for (Event element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Event... updatedElement) {
    em.getTransaction().begin();
    for (Event element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Event... elements) {
    em.getTransaction().begin();
    for (Event element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
