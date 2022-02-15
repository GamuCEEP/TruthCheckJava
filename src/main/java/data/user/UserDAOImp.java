package data.user;

import domain.user.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAOImp implements UserDAO {

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
  public Set<User> findAll() {
    List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
    List<User> result = users != null ? users : new ArrayList<>();
    return new HashSet<>(result);
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
