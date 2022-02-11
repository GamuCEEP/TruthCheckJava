package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Stage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class StageDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public StageDAO() {
    em = ConnectionManager.getEM();
  }

  public Stage find(int name) {
    return em.find(Stage.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Stage u").getResultList();
  }

  public void persist(Stage... elements) {
    em.getTransaction().begin();
    for (Stage element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Stage... updatedElement) {
    em.getTransaction().begin();
    for (Stage element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Stage... elements) {
    em.getTransaction().begin();
    for (Stage element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
