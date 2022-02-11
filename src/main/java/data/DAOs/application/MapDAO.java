package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Map;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class MapDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public MapDAO() {
    em = ConnectionManager.getEM();
  }

  public Map find(int name) {
    return em.find(Map.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Map u").getResultList();
  }

  public void persist(Map... elements) {
    em.getTransaction().begin();
    for (Map element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Map... updatedElement) {
    em.getTransaction().begin();
    for (Map element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Map... elements) {
    em.getTransaction().begin();
    for (Map element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
