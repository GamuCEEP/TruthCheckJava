package service.application;

import domain.application.Map;
import domain.application.Resource;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface MapService {

  Map find(int id);

  Set<Map> findAll();

  Set<Map> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}