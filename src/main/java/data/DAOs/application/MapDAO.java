package data.DAOs.application;

import domain.beans.application.Map;
import domain.beans.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
public class MapDAO implements IResourceDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public MapDAO() {
    em = Persistence.createEntityManagerFactory("TruthCheckJava").createEntityManager();
  }

  @Override
  public Map find(int name) {
    return em.find(Map.class, name);
  }

  @Override
  public List<Map> findAll() {
    return em.createQuery("SELECT u FROM Map u").getResultList();
  }

  @Override
  public void persist(Resource resource) {
    em.getTransaction().begin();
    em.persist(resource);
    em.getTransaction().commit();
  }

  @Override
  public void merge(Resource resource) {
    em.getTransaction().begin();
    em.merge(resource);
    em.getTransaction().commit();
  }

  @Override
  public void remove(Resource resource) {
    em.getTransaction().begin();
    em.remove(resource);
    em.getTransaction().commit();
  }

  @Override
  public List<Map> findText(String text) {
    return em.createQuery("SELECT u FROM Map u WHERE u.name LIKE '%" + text + "%' OR u.description LIKE '%" + text + "%'").getResultList();
  }
}
