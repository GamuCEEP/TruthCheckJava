package service.application;

import data.application.IResourceDAO;
import data.application.EventDAO;
import domain.application.Event;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventService implements IResourceDAO {

  @Inject
  private EventDAO dao;

  @Override
  public Event find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Event> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Event> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist(resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge(resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove(resource);
  }

}
