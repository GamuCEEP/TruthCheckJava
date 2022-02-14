package service.application;

import data.application.ItemDAO;
import domain.application.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ItemService  {

 @Inject
  private ItemDAO dao;
 
  public Item find(int id) {
    return dao.find(id);
  }
  
  public List<Item> findText(String text) {
    if (text.isEmpty()) {
      return findAll();
    }
    return dao.findText(text);
  }
  
  public List<Item> findAll() {
    return dao.findAll();
  }
  
  public void persist(Item resource) {
    dao.persist(resource);
  }
  
  public void merge(Item resource) {
    dao.merge(resource);
  }
  
  public void remove(Item resource) {
    dao.remove(resource);
  }
}

