package service.application;

import data.DAOs.application.*;
import domain.beans.application.Resource;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IResourceService {

  public Resource find(int id);
  public List<? extends Resource> findText(String text);
  public List<? extends Resource> findAll();
  public void persist(Resource resource);
  public void merge(Resource resource);
  public void remove(Resource resource);
}
