package service.application;

import data.application.ItemDAO;
import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ItemService   implements ResourceService{

 @Inject
  private ItemDAO dao;
 
 @Override
  public Item find(int id) {
    return dao.find(id);
  }
  
 @Override
  public List<Item> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
 @Override
  public List<Item> findAll() {
    return dao.findAll();
  }
  
  public void persist(Resource resource) {
    dao.persist((Item)resource);
  }
  
  public void merge(Resource resource) {
    dao.merge((Item)resource);
  }
  
  public void remove(Resource resource) {
    dao.remove((Item)resource);
  }
}

