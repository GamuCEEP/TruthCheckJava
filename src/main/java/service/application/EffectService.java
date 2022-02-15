package service.application;

import domain.application.Effect;
import domain.application.Resource;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface EffectService {

  Effect find(int id);

  Set<Effect> findAll();

  Set<Effect> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
  
}
