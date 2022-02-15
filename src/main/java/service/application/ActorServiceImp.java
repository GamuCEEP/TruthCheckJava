package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.ActorDAO;

@Stateless
public class ActorServiceImp implements ActorService{

  @Inject
  private ActorDAO dao;

  @Override
  public Actor find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Actor> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }

  @Override
  public List<Actor> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist((Actor)resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Actor)resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Actor)resource);
  }
}
