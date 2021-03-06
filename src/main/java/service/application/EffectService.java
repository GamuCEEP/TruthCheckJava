package service.application;

import data.application.EffectDAO;
import data.application.IResourceDAO;
import domain.application.Effect;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EffectService implements IResourceDAO {

  @Inject
  private EffectDAO dao;

 @Override
  public Effect find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Effect> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Effect> findAll() {
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
