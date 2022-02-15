package data.application;

import domain.application.Stage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class StageDAOImp implements StageDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Stage find(int name) {
    return em.find(Stage.class, name);
  }

  @Override
  public List<Stage> findAll() {
    List<Stage> stages = em.createQuery("SELECT u FROM Stage u").getResultList();
    return stages != null ? stages : new ArrayList<>();
  }

  @Override
  public void persist(Stage resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Stage resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Stage resource) {
    em.remove(resource);
  }

  @Override
  public List<Stage> findText(String text) {
    List<Stage> stages = em.createQuery("SELECT u FROM Stage u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return stages != null ? stages : new ArrayList<>();

  }
}
