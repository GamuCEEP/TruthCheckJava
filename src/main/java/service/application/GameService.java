package service.application;

import data.DAOs.application.*;
import domain.beans.application.Resource;
import domain.beans.application.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GameService implements IResourceDAO {

  @Inject
  private GameDAO dao;

  @Override
  public Game find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Game> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Game> findAll() {
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
