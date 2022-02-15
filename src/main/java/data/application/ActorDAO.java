package data.application;

import domain.application.Actor;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface ActorDAO {

  Actor find(int name);

  Set<Actor> findAll();

  Set<Actor> findText(String text);

  void merge(Actor resource);

  void persist(Actor resource);

  void remove(Actor resource);

}
