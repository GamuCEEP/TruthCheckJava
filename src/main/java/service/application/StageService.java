package service.application;

import domain.application.Resource;
import domain.application.Stage;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface StageService {

  Stage find(int id);

  Set<Stage> findAll();

  Set<Stage> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}