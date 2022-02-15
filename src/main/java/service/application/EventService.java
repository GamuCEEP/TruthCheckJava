package service.application;

import domain.application.Event;
import domain.application.Resource;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface EventService {

  Event find(int id);

  Set<Event> findAll();

  Set<Event> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
