package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.EventDAO;
import java.util.Set;

@Stateless
public class EventServiceImp implements EventService   {

  @Inject
  private EventDAO dao;

  @Override
  public Event find(int id) {
    return dao.find(id);
  }

  @Override
  public Set<Event> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  @Override
  public Set<Event> findAll() {
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
