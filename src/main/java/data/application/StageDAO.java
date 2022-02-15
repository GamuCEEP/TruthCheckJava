package data.application;

import domain.application.Stage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class StageDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public Stage find(int name) {
    return em.find(Stage.class, name);
  }

  public List<Stage> findAll() {
    List<Stage> stages = em.createQuery("SELECT u FROM Stage u").getResultList();
    return stages != null ? stages : new ArrayList<>();
  }

  public void persist(Stage resource) {
    em.persist(resource);
  }

  public void merge(Stage resource) {
    em.merge(resource);
  }

  public void remove(Stage resource) {
    em.remove(resource);
  }

  public List<Stage> findText(String text) {
    List<Stage> stages = em.createQuery("SELECT u FROM Stage u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return stages != null ? stages : new ArrayList<>();

  }
}
