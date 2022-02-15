package data.application;

import domain.application.Interaction;
import java.util.ArrayList;
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
    List<Interaction> interactions = em.createQuery("SELECT u FROM Interaction u").getResultList();
    return interactions != null ? interactions : new ArrayList<>();
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
    List<Interaction> interactions = em.createQuery("SELECT u FROM Interaction u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return interactions != null ? interactions : new ArrayList<>();

  }
}
