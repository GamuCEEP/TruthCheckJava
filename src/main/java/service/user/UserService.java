package service.user;

import data.user.UserDAO;
import domain.user.User;
import java.util.List;
import javax.inject.Inject;

public class UserService {

  @Inject
  UserDAO DAO;

  public User find(int id) {
    return DAO.find(id);
  }

  public User find(String text) {
    return DAO.find(text);
  }

  public List<User> findAll() {
    return DAO.findAll();
  }

  public void persist(User resource) {
    DAO.persist(resource);
  }

  public void merge(User resource) {
    DAO.merge(resource);
  }

  public void remove(User resource) {
    DAO.remove(resource);
  }
}
