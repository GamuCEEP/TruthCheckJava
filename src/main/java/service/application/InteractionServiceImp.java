package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.InteractionDAO;
import java.util.Set;

@Stateless
public class InteractionServiceImp implements InteractionService {

  @Inject
  private InteractionDAO dao;

  @Override
  public Interaction find(int id) {
    return dao.find(id);
  }

  @Override
  public Set<Interaction> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  @Override
  public Set<Interaction> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist((Interaction)resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Interaction)resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Interaction)resource);
  }
}
