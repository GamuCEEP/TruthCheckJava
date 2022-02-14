package service.application;

import data.application.RelationDAO;
import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RelationService implements ResourceService {

  @Inject
  private RelationDAO dao;

  @Override
  public Relation find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Relation> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }

  @Override
  public List<Relation> findAll() {
    return dao.findAll();
  }

  public void persist(Resource resource) {
    dao.persist((Relation) resource);
  }

  public void merge(Resource resource) {
    dao.merge((Relation) resource);
  }

  public void remove(Resource resource) {
    dao.remove((Relation) resource);
  }

}
