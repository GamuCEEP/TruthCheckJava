package data.application;

import domain.application.Stage;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StageDAO {

  Stage find(int name);

  List<Stage> findAll();

  List<Stage> findText(String text);

  void merge(Stage resource);

  void persist(Stage resource);

  void remove(Stage resource);
  
}
