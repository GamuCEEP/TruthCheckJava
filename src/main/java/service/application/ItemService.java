package service.application;

import domain.application.Item;
import domain.application.Resource;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface ItemService {

  Item find(int id);

  Set<Item> findAll();

  Set<Item> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
