package data.DAOs.application;

import domain.beans.application.Actor;
import domain.beans.application.Resource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class ActorDAO implements IResourceDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public ActorDAO() {
    em = Persistence.createEntityManagerFactory("TruthCheckJava").createEntityManager();
  }

  @Override
  public Actor find(int name) {
    return em.find(Actor.class, name);
  }

  @Override
  public List<Actor> findAll() {
    return em.createQuery("SELECT u FROM Actor u").getResultList();
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
    return em.createQuery("SELECT u FROM Actor u WHERE u.name LIKE '%" + text + "%' OR u.description LIKE '%" + text + "%'").getResultList();
  }

}
