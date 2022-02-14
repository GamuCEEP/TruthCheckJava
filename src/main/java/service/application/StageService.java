package service.application;

import data.application.IResourceDAO;
import data.application.StageDAO;
import domain.application.Resource;
import domain.application.Stage;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StageService implements IResourceDAO {

  @Inject
  private StageDAO dao;

  @Override
  public Stage find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Stage> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Stage> findAll() {
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
