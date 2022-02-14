package service.application;

import domain.application.*;
import java.util.List;

/**
 *
 * @author GamuD
 */
public interface ResourceService {
  
  Resource find(int id);

  List<? extends Resource> findAll();

  List<? extends Resource> findText(String text);

  void merge(Resource resource);

  void persist(Resource resource);

  void remove(Resource resource);
}
