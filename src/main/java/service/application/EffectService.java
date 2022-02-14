package service.application;

import data.application.EffectDAO;
import domain.application.Effect;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EffectService {

  @Inject
  private EffectDAO dao;

  public Effect find(int id) {
    return dao.find(id);
  }

  public List<Effect> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  public List<Effect> findAll() {
    return dao.findAll();
  }

  public void persist(Effect resource) {
    dao.persist(resource);
  }

  public void merge(Effect resource) {
    dao.merge(resource);
  }

  public void remove(Effect resource) {
    dao.remove(resource);
  }
}
