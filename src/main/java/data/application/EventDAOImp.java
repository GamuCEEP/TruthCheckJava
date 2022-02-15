package data.application;

import domain.application.Event;
import java.util.ArrayList;
import java.util.List;
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
  public List<Event> findAll() {
    List<Event> events = em.createQuery("SELECT u FROM Event u").getResultList();
    return events != null ? events : new ArrayList<>();
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
  public List<Event> findText(String text) {
    List<Event> events = em.createQuery("SELECT u FROM Event u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
    return events != null ? events : new ArrayList<>();
  }
}
