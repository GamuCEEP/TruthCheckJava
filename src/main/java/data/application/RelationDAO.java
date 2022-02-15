package data.application;

import domain.application.Relation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class RelationDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public Relation find(int name) {
    return em.find(Relation.class, name);
  }

  public List<Relation> findAll() {
    List<Relation> relations = em.createQuery("SELECT u FROM Relation u").getResultList();
    return relations != null ? relations : new ArrayList<>();
  }

  public void persist(Relation resource) {
    em.persist(resource);
  }

  public void merge(Relation resource) {
    em.merge(resource);
  }

  public void remove(Relation resource) {
    em.remove(resource);
  }

  public List<Relation> findText(String text) {
    List<Relation> relations = em.createQuery("SELECT u FROM Relation u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return relations != null ? relations : new ArrayList<>();

  }
}
