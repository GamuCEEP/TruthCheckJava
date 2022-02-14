package data.application;

import domain.application.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EventDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;
  
  public Event find(int name) {
    return em.find(Event.class, name);
  }
  
  public List<Event> findAll() {
    return em.createQuery("SELECT u FROM Event u").getResultList();
  }
  
  public void persist(Event resource) {
    em.persist(resource);
  }
  
  public void merge(Event resource) {
    em.merge(resource);
  }
  
  public void remove(Event resource) {
    em.remove(resource);
  }
  
  public List<Event> findText(String text) {
    return em.createQuery("SELECT u FROM Event u WHERE u.name LIKE '%:text%' OR u.description LIKE '%:text%'")
            .setParameter("text", text)
            .getResultList();
  }
}
