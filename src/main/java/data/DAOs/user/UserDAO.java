package data.DAOs.user;

import domain.beans.user.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserDAO implements IUserDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  @Override
  public User find(int id) {
    return em.find(User.class, id);
  }

  @Override
  public User find(String name) {
    List<User> users = em.createQuery(
            "SELECT u FROM User u WHERE u.name = :name").setParameter("name",
                    name).getResultList();
    if (users.isEmpty()) {
      return null;
    }
    return users.get(0);

  }

  @Override
  public List<User> findAll() {
    return em.createQuery("SELECT u FROM User u").getResultList();
  }

  @Override
  public void persist(User... users) {
    for (User user : users) {
      em.persist(user);
    }
  }

  @Override
  public void merge(User... updatedUsers) {
    for (User user : updatedUsers) {
      em.merge(user);
    }
  }

  @Override
  public void remove(User... users) {
    for (User user : users) {
      em.remove(user);
    }
  }
}
