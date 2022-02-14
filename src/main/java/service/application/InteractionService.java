package service.application;

import data.application.InteractionDAO;
import domain.application.Interaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class InteractionService {

  @Inject
  private InteractionDAO dao;

  public Interaction find(int id) {
    return dao.find(id);
  }

  public List<Interaction> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  public List<Interaction> findAll() {
    return dao.findAll();
  }

  public void persist(Interaction resource) {
    dao.persist(resource);
  }

  public void merge(Interaction resource) {
    dao.merge(resource);
  }

  public void remove(Interaction resource) {
    dao.remove(resource);
  }
}
