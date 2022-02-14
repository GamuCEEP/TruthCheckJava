package service.application;

import data.application.EffectDAO;
import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EffectService  implements ResourceService{

  @Inject
  private EffectDAO dao;

  @Override
  public Effect find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Effect> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  @Override
  public List<Effect> findAll() {
    return dao.findAll();
  }

  @Override
  public void persist(Resource resource) {
    dao.persist((Effect)resource);
  }

  @Override
  public void merge(Resource resource) {
    dao.merge((Effect)resource);
  }

  @Override
  public void remove(Resource resource) {
    dao.remove((Effect)resource);
  }
}
