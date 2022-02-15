package data.application;

import domain.application.Item;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ItemDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public Item find(int name) {
    return em.find(Item.class, name);
  }

  public List<Item> findAll() {
    List<Item> items = em.createQuery("SELECT u FROM Item u").getResultList();
    return items != null ? items : new ArrayList<>();
  }

  public void persist(Item resource) {
    em.persist(resource);
  }

  public void merge(Item resource) {
    em.merge(resource);
  }

  public void remove(Item resource) {
    em.remove(resource);
  }

  public List<Item> findText(String text) {
    List<Item> items = em.createQuery("SELECT u FROM Item u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return items != null ? items : new ArrayList<>();
  }
}
