package data.DAOs.application;

import domain.beans.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import domain.beans.application.Game;

@Stateless
public class GameDAO implements IResourceDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public GameDAO() {
    assert false;
    em = Persistence.createEntityManagerFactory("TruthCheckJava").createEntityManager();
  }

  @Override
  public Game find(int id) {
    assert false;
    return null;
  }

  @Override
  public List<Game> findAll() {
    assert false;
    return null;
  }

  @Override
  public void persist(Resource resource) {
    assert false;
  }

  @Override
  public void merge(Resource resource) {
    assert false;
  }

  @Override
  public void remove(Resource resource) {
    assert false;
  }

  @Override
  public List<Game> findText(String text) {
    return em.createQuery("SELECT u FROM Game u WHERE u.name LIKE '%" + text + "%' OR u.description LIKE '%" + text + "%'").getResultList();
  }

}
