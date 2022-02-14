package service.application;

import data.DAOs.application.*;
import domain.beans.application.Resource;
import domain.beans.application.Relation;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RelationService implements IResourceDAO {

  @Inject
  private RelationDAO dao;

  @Override
  public Relation find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Relation> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Relation> findAll() {
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
