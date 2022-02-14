package data.DAOs.user;

import domain.beans.user.User;
import java.util.List;
import javax.ejb.Stateless;


public interface IUserDAO {
  
  public User find(int id);
  public User find(String name);
  public List<User> findAll();
  public void merge(User... updatedUsers);
  public void persist(User... users);
  public void remove(User... users);

}
