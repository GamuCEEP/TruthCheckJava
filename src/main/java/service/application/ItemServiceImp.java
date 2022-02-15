package service.application;

import domain.application.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import data.application.ItemDAO;
import java.util.Set;

@Stateless
public class ItemServiceImp   implements ItemService{

 @Inject
  private ItemDAO dao;
 
 @Override
  public Item find(int id) {
    return dao.find(id);
  }
  
 @Override
  public Set<Item> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
 @Override
  public Set<Item> findAll() {
    return dao.findAll();
  }
  
  @Override
  public void persist(Resource resource) {
    dao.persist((Item)resource);
  }
  
  @Override
  public void merge(Resource resource) {
    dao.merge((Item)resource);
  }
  
  @Override
  public void remove(Resource resource) {
    dao.remove((Item)resource);
  }
}

