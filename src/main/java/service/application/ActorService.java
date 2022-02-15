package service.application;

import domain.application.Actor;
import domain.application.Resource;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ActorService {

  Actor find(int id);

  List<Actor> findAll();

  List<Actor> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
