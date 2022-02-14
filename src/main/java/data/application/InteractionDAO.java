package data.application;

import domain.application.Interaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class InteractionDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;
  
  public Interaction find(int name) {
    return em.find(Interaction.class, name);
  }
  
  public List<Interaction> findAll() {
    return em.createQuery("SELECT u FROM Interaction u").getResultList();
  }
  
  public void persist(Interaction resource) {
    em.persist(resource);
  }
  
  public void merge(Interaction resource) {
    em.merge(resource);
  }
  
  public void remove(Interaction resource) {
    em.remove(resource);
  }
  
  public List<Interaction> findText(String text) {
    return em.createQuery("SELECT u FROM Interaction u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
  }
}
