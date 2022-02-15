package data.application;

import domain.application.Effect;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EffectDAO {

  Effect find(int name);

  List<Effect> findAll();

  List<Effect> findText(String text);

  void merge(Effect resource);

  void persist(Effect resource);

  void remove(Effect resource);
  
}
