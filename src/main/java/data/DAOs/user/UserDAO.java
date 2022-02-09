package data.DAOs.user;

import data.SQL.ConnectionManager;
import domain.beans.user.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public UserDAO() {
    this.em = ConnectionManager.getEM();
  }

  public User select(String name) {
    return em.find(User.class, name);
  }

  public List<User> selectAll() {
    return em.createQuery("SELECT u FROM User u").getResultList();
  }

  public void insert(User... users) {
    em.getTransaction().begin();
    for (User user : users) {
      em.persist(user);
    }
    em.getTransaction().commit();
  }

  public void update(User... updatedUsers) {
    em.getTransaction().begin();
    for (User user : updatedUsers) {
      em.merge(user);
    }
    em.getTransaction().commit();
  }

  public void delete(User... users) {
    em.getTransaction().begin();
    for (User user : users) {
      em.remove(user);
    }
    em.getTransaction().commit();
  }
}
