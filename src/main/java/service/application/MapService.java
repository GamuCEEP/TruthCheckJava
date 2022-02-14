package service.application;

import data.application.MapDAO;
import domain.application.Map;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MapService {

  @Inject
  private MapDAO dao;
  
  public Map find(int id) {
    return dao.find(id);
  }
  
  public List<Map> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
  public List<Map> findAll() {
    return dao.findAll();
  }
  
  public void persist(Map resource) {
    dao.persist(resource);
  }
  
  public void merge(Map resource) {
    dao.merge(resource);
  }
  
  public void remove(Map resource) {
    dao.remove(resource);
  }
}
