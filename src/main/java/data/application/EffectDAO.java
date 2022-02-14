package data.application;

import domain.application.Effect;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EffectDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;
  
  public Effect find(int name) {
    return em.find(Effect.class, name);
  }
  
  public List<Effect> findAll() {
    return em.createQuery("SELECT u FROM Effect u").getResultList();
  }
  
  public void persist(Effect resource) {
    em.persist(resource);
  }
  
  public void merge(Effect resource) {
    em.merge(resource);
  }
  
  public void remove(Effect resource) {
    em.remove(resource);
  }
  
  public List<Effect> findText(String text) {
    return em.createQuery("SELECT u FROM Effect u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
  }
}
