package service.application;

import data.application.EventDAO;
import domain.application.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventService {

  @Inject
  private EventDAO dao;

  public Event find(int id) {
    return dao.find(id);
  }

  public List<Event> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  public List<Event> findAll() {
    return dao.findAll();
  }

  public void persist(Event resource) {
    dao.persist(resource);
  }

  public void merge(Event resource) {
    dao.merge(resource);
  }

  public void remove(Event resource) {
    dao.remove(resource);
  }

}
