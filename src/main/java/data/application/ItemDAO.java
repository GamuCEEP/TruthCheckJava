package data.application;

import domain.application.Item;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface ItemDAO {

  Item find(int name);

  Set<Item> findAll();

  Set<Item> findText(String text);

  void merge(Item resource);

  void persist(Item resource);

  void remove(Item resource);
  
}
