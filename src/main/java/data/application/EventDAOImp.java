package data.application;

import domain.application.Event;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EventDAOImp implements EventDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public Event find(int name) {
    return em.find(Event.class, name);
  }

  @Override
  public Set<Event> findAll() {
    List<Event> events = em.createQuery("SELECT u FROM Event u").getResultList();
    List<Event> result = events != null ? events : new ArrayList<>();
    return new HashSet<>(result);
  }

  @Override
  public void persist(Event resource) {
    em.persist(resource);
  }

  @Override
  public void merge(Event resource) {
    em.merge(resource);
  }

  @Override
  public void remove(Event resource) {
    em.remove(resource);
  }

  @Override
  public Set<Event> findText(String text) {
    List<Event> events = em.createQuery("SELECT u FROM Event u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    List<Event> result = events != null ? events : new ArrayList<>();
    return new HashSet<>(result);
  }
}
