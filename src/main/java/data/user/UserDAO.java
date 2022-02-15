package data.user;

import domain.user.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserDAO {
  
  public User find(int id);
  public User find(String name);
  public List<User> findAll();
  public void merge(User... updatedUsers);
  public void persist(User... users);
  public void remove(User... users);

}
