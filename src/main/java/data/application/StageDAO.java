package data.application;

import domain.application.Stage;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface StageDAO {

  Stage find(int name);

  Set<Stage> findAll();

  Set<Stage> findText(String text);

  void merge(Stage resource);

  void persist(Stage resource);

  void remove(Stage resource);
  
}
