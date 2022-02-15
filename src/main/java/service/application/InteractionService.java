package service.application;

import domain.application.Interaction;
import domain.application.Resource;
import java.util.List;

import javax.ejb.Local;

@Local
public interface InteractionService {

  Interaction find(int id);

  List<Interaction> findAll();

  List<Interaction> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
