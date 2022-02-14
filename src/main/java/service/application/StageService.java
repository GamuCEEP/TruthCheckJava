package service.application;

import data.application.StageDAO;
import domain.application.Stage;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StageService {

  @Inject
  private StageDAO dao;
  
  public Stage find(int id) {
    return dao.find(id);
  }
  
  public List<Stage> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
  public List<Stage> findAll() {
    return dao.findAll();
  }
  
  public void persist(Stage resource) {
    dao.persist(resource);
  }
  
  public void merge(Stage resource) {
    dao.merge(resource);
  }
  
  public void remove(Stage resource) {
    dao.remove(resource);
  }
}
