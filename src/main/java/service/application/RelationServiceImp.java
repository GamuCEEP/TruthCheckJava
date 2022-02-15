package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.RelationDAO;

@Stateless
public class RelationServiceImp implements RelationService {

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

  @Override
  public void persist(Resource resource) {
    dao.persist((Relation) resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Relation) resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Relation) resource);
  }

}
