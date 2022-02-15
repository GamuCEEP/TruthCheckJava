package service.application;

import domain.application.Resource;
import domain.application.Stage;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.StageDAO;
import java.util.Set;

@Stateless
public class StageServiceImp implements StageService {

  @Inject
  private StageDAO dao;
  
  @Override
  public Stage find(int id) {
    return dao.find(id);
  }
  
  @Override
  public Set<Stage> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
  @Override
  public Set<Stage> findAll() {
    return dao.findAll();
  }
  
  @Override
  public void persist(Resource resource) {
    dao.persist((Stage)resource);
  }
  
  @Override
  public void merge(Resource resource) {
    dao.merge((Stage)resource);
  }
  
  @Override
  public void remove(Resource resource) {
    dao.remove((Stage)resource);
  }
}
