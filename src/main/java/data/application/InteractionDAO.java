package data.application;

import domain.application.Interaction;
import java.util.List;
import javax.ejb.Local;

@Local
public interface InteractionDAO {

  Interaction find(int name);

  List<Interaction> findAll();

  List<Interaction> findText(String text);

  void merge(Interaction resource);

  void persist(Interaction resource);

  void remove(Interaction resource);
  
}
