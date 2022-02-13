package data.DAOs.application;

import domain.beans.application.Effect;
import domain.beans.application.Resource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EffectDAO implements IResourceDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public EffectDAO() {
    em = Persistence.createEntityManagerFactory("TruthCheckJava").createEntityManager();
  }

  @Override
  public Effect find(int name) {
    return em.find(Effect.class, name);
  }

  @Override
  public List<Effect> findAll() {
    return em.createQuery("SELECT u FROM Effect u").getResultList();
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
  public List<? extends Resource> findText(String text) {
    return em.createQuery("SELECT u FROM Effect u WHERE u.name LIKE '%" + text + "%' OR u.description LIKE '%" + text + "%'").getResultList();
  }
}
