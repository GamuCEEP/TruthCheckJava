package data.application;

import domain.application.Map;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface MapDAO {

  Map find(int name);

  Set<Map> findAll();

  Set<Map> findText(String text);

  void merge(Map resource);

  void persist(Map resource);

  void remove(Map resource);
  
}
