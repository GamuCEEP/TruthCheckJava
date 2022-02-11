package data.DAOs.application;

import data.SQL.ConnectionManager;
import domain.beans.application.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class ItemDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public ItemDAO() {
    em = ConnectionManager.getEM();
  }

  public Item find(int name) {
    return em.find(Item.class, name);
  }

  public List<?> findAll() {
    return em.createQuery("SELECT u FROM Item u").getResultList();
  }

  public void persist(Item... elements) {
    em.getTransaction().begin();
    for (Item element : elements) {
      em.persist(element);
    }
    em.getTransaction().commit();
  }

  public void merge(Item... updatedElement) {
    em.getTransaction().begin();
    for (Item element : updatedElement) {
      em.merge(element);
    }
    em.getTransaction().commit();
  }

  public void remove(Item... elements) {
    em.getTransaction().begin();
    for (Item element : elements) {
      em.remove(element);
    }
    em.getTransaction().commit();
  }
}
