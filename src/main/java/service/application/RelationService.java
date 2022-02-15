package service.application;

import domain.application.Relation;
import domain.application.Resource;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface RelationService {

  Relation find(int id);

  Set<Relation> findAll();

  Set<Relation> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);

}
