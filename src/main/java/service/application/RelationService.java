package service.application;

import data.application.RelationDAO;
import domain.application.Relation;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RelationService {

  @Inject
  private RelationDAO dao;
  
  public Relation find(int id) {
    return dao.find(id);
  }
  
  public List<Relation> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
  public List<Relation> findAll() {
    return dao.findAll();
  }
  
  public void persist(Relation resource) {
    dao.persist(resource);
  }
  
  public void merge(Relation resource) {
    dao.merge(resource);
  }
  
  public void remove(Relation resource) {
    dao.remove(resource);
  }

}
