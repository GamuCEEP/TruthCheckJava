package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.EffectDAO;
import java.util.Set;

@Stateless
public class EffectServiceImp  implements EffectService{

  @Inject
  private EffectDAO dao;

  @Override
  public Effect find(int id) {
    return dao.find(id);
  }

  @Override
  public Set<Effect> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }

    return dao.findText(text);
  }

  @Override
  public Set<Effect> findAll() {
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
