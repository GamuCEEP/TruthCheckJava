package service.user;

import domain.user.User;
import java.util.List;

import javax.ejb.Local;

@Local
public interface UserService {

  User find(int id);

  User find(String text);

  List<User> findAll();

  void merge(User resource);

  void persist(User resource);

  void remove(User resource);
  
}
