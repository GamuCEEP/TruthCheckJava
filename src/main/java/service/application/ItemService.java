package service.application;

import data.application.ItemDAO;
import data.application.IResourceDAO;
import domain.application.Item;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ItemService implements IResourceDAO {

 @Inject
  private ItemDAO dao;
  
 @Override
  public Item find(int id) {
    return dao.find(id);
  }

  @Override
  public List<Item> findText(String text) {
    return dao.findText(text);
  }

  @Override
  public List<Item> findAll() {
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

