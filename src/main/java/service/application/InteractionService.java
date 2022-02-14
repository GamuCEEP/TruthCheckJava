package service.application;

import data.application.IResourceDAO;
import data.application.InteractionDAO;
import domain.application.Interaction;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class InteractionService implements IResourceDAO {

  @Inject
  private InteractionDAO dao;
 @Override
  public Interaction find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Interaction> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Interaction> findAll() {
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

