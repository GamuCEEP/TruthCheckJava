package service.application;

import data.application.ActorDAO;
import data.application.IResourceDAO;
import domain.application.Actor;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ActorService implements IResourceDAO {

  @Inject
  private ActorDAO dao;

  @Override
  public Actor find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Actor> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Actor> findAll() {
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
