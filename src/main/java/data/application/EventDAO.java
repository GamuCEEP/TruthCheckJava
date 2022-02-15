package data.application;

import domain.application.Event;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface EventDAO {

  Event find(int name);

  Set<Event> findAll();

  Set<Event> findText(String text);

  void merge(Event resource);

  void persist(Event resource);

  void remove(Event resource);
  
}
