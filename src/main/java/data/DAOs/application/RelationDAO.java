package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Relation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class RelationDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public RelationDAO() {
    em = ConnectionManager.getEM();
  }

  public Relation find(int name) {
    return em.find(Relation.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Relation u").getResultList();
  }

  public void persist(Relation... elements) {
    em.getTransaction().begin();
    for (Relation element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Relation... updatedElement) {
    em.getTransaction().begin();
    for (Relation element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Relation... elements) {
    em.getTransaction().begin();
    for (Relation element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
