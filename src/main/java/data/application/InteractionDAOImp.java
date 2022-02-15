package data.application;

import domain.application.Interaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class InteractionDAOImp implements InteractionDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Interaction find(int name) {
    return em.find(Interaction.class, name);
  }

  @Override
  public Set<Interaction> findAll() {
    List<Interaction> interactions = em.createQuery("SELECT u FROM Interaction u").getResultList();
    List<Interaction> result = interactions != null ? interactions : new ArrayList<>();
    return new HashSet<>(result);
  }

  @Override
  public void persist(Interaction resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Interaction resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Interaction resource) {
    em.remove(resource);
  }

  @Override
  public Set<Interaction> findText(String text) {
    List<Interaction> interactions = em.createQuery("SELECT u FROM Interaction u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Interaction> result = interactions != null ? interactions : new ArrayList<>();
    return new HashSet<>(result);

  }
}
