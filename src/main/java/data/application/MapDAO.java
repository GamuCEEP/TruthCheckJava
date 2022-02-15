package data.application;

import domain.application.Map;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class MapDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public Map find(int name) {
    return em.find(Map.class, name);
  }

  public List<Map> findAll() {
    List<Map> maps = em.createQuery("SELECT u FROM Map u").getResultList();
    return maps != null ? maps : new ArrayList<>();
  }

  public void persist(Map resource) {
    em.persist(resource);
  }

  public void merge(Map resource) {
    em.merge(resource);
  }

  public void remove(Map resource) {
    em.remove(resource);
  }

  public List<Map> findText(String text) {
    List<Map> maps = em.createQuery("SELECT u FROM Map u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return maps != null ? maps : new ArrayList<>();

  }
}
