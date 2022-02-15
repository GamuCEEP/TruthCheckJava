package service.application;

import domain.application.Relation;
import domain.application.Resource;
import java.util.List;

import javax.ejb.Local;

@Local
public interface RelationService {

  Relation find(int id);

  List<Relation> findAll();

  List<Relation> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
