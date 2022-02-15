package service.application;

import domain.application.Event;
import domain.application.Resource;
import java.util.List;

import javax.ejb.Local;

@Local
public interface EventService {

  Event find(int id);

  List<Event> findAll();

  List<Event> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
