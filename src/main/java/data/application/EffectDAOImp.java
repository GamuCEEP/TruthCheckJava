package data.application;

import domain.application.Effect;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EffectDAOImp implements EffectDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;
  
  @Override
  public Effect find(int name) {
    return em.find(Effect.class, name);
  }
  
  @Override
  public Set<Effect> findAll() {
    List<Effect> effects = em.createQuery("SELECT u FROM Effect u").getResultList();
    List<Effect> result = effects != null ? effects : new ArrayList<>();
    return new HashSet<>(result);
  }
  
  @Override
  public void persist(Effect resource) {
    em.persist(resource);
  }
  
  @Override
  public void merge(Effect resource) {
    em.merge(resource);
  }
  
  @Override
  public void remove(Effect resource) {
    em.remove(resource);
  }
  
  @Override
  public Set<Effect> findText(String text) {
    List<Effect> effects = em.createQuery("SELECT u FROM Effect u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Effect> result = effects != null ? effects : new ArrayList<>();
    return new HashSet<>(result);
  }
}
