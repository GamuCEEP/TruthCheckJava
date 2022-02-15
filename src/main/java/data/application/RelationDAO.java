package data.application;

import domain.application.Relation;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RelationDAO {

  Relation find(int name);

  List<Relation> findAll();

  List<Relation> findText(String text);

  void merge(Relation resource);

  void persist(Relation resource);

  void remove(Relation resource);
  
}
