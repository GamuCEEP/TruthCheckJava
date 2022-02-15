package service.user;

import data.user.UserDAO;
import domain.user.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImp implements UserService {

  @Inject
  UserDAO DAO;

  @Override
  public User find(int id) {
    return DAO.find(id);
  }

  @Override
  public User find(String text) {
    return DAO.find(text);
  }

  @Override
  public List<User> findAll() {
    return DAO.findAll();
  }

  @Override
  public void persist(User resource) {
    DAO.persist(resource);
  }

  @Override
  public void merge(User resource) {
    DAO.merge(resource);
  }

  @Override
  public void remove(User resource) {
    DAO.remove(resource);
  }
}
