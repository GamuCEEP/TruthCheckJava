package service.application;

import data.application.MapDAO;
import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MapService implements ResourceService {

  @Inject
  private MapDAO dao;

  @Override
  public Map find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Map> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }

  @Override
  public List<Map> findAll() {
    return dao.findAll();
  }

  public void persist(Resource resource) {
    dao.persist((Map) resource);
  }

  public void merge(Resource resource) {
    dao.merge((Map) resource);
  }

  public void remove(Resource resource) {
    dao.remove((Map) resource);
  }
}
