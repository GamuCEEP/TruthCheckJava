package data.application;

import domain.application.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class MapDAOImp implements MapDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Map find(int name) {
    return em.find(Map.class, name);
  }

  @Override
  public Set<Map> findAll() {
    List<Map> maps = em.createQuery("SELECT u FROM Map u").getResultList();
    List<Map> result = maps != null ? maps : new ArrayList<>();
    return new HashSet<>(result);
  }

  @Override
  public void persist(Map resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Map resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Map resource) {
    em.remove(resource);
  }

  @Override
  public Set<Map> findText(String text) {
    List<Map> maps = em.createQuery("SELECT u FROM Map u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Map> result = maps != null ? maps : new ArrayList<>();
    return new HashSet<>(result);

  }
}
