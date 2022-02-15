package data.application;

import domain.application.Map;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MapDAO {

  Map find(int name);

  List<Map> findAll();

  List<Map> findText(String text);

  void merge(Map resource);

  void persist(Map resource);

  void remove(Map resource);
  
}
