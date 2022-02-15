package data.application;

import domain.application.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ItemDAOImp implements ItemDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Item find(int name) {
    return em.find(Item.class, name);
  }

  @Override
  public Set<Item> findAll() {
    List<Item> items = em.createQuery("SELECT u FROM Item u").getResultList();
    List<Item> result = items != null ? items : new ArrayList<>();
    return new HashSet<>(result);
  }

  @Override
  public void persist(Item resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Item resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Item resource) {
    em.remove(resource);
  }

  @Override
  public Set<Item> findText(String text) {
    List<Item> items = em.createQuery("SELECT u FROM Item u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Item> result = items != null ? items : new ArrayList<>();
    return new HashSet<>(result);
  }
}
