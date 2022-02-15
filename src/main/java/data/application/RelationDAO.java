package data.application;

import domain.application.Relation;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

@Local
public interface RelationDAO {

  Relation find(int name);

  Set<Relation> findAll();

  Set<Relation> findText(String text);

  void merge(Relation resource);

  void persist(Relation resource);

  void remove(Relation resource);
  
}
