package data.application;

import domain.application.Stage;
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
    return em.createQuery("SELECT u FROM Stage u").getResultList();
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
    return em.createQuery("SELECT u FROM Stage u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
  }
}
