package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.MapDAO;
import java.util.Set;

@Stateless
public class MapServiceImp implements MapService {

  @Inject
  private MapDAO dao;

  @Override
  public Map find(int id) {
    return dao.find(id);
  }

  @Override
  public Set<Map> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }

  @Override
  public Set<Map> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist((Map) resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Map) resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Map) resource);
  }
}
