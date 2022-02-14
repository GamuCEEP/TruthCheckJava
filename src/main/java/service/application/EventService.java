package service.application;

import data.application.EventDAO;
import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventService  implements ResourceService{

  @Inject
  private EventDAO dao;

  @Override
  public Event find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Event> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  @Override
  public List<Event> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist((Event)resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Event)resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Event)resource);
  }

}
