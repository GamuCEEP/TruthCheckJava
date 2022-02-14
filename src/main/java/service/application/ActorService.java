package service.application;

import data.application.ActorDAO;
import domain.application.Actor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ActorService {

  @Inject
  private ActorDAO dao;

  public Actor find(int id) {
    return dao.find(id);
  }

  public List<Actor> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }

  public List<Actor> findAll() {
    return dao.findAll();
  }

  public void persist(Actor resource) {
    dao.persist(resource);
  }

  public void merge(Actor resource) {
    dao.merge(resource);
  }

  public void remove(Actor resource) {
    dao.remove(resource);
  }
}
