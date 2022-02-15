package data.application;

import domain.application.Relation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class RelationDAOImp implements RelationDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Relation find(int name) {
    return em.find(Relation.class, name);
  }

  @Override
  public List<Relation> findAll() {
    List<Relation> relations = em.createQuery("SELECT u FROM Relation u").getResultList();
    return relations != null ? relations : new ArrayList<>();
  }

  @Override
  public void persist(Relation resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Relation resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Relation resource) {
    em.remove(resource);
  }

  @Override
  public List<Relation> findText(String text) {
    List<Relation> relations = em.createQuery("SELECT u FROM Relation u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return relations != null ? relations : new ArrayList<>();

  }
}
