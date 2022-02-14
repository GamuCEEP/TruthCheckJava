package data.DAOs.user;

import domain.beans.user.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserDAO {

  @PersistenceContext(unitName = "TruthCheckJava")
  EntityManager em;

  public User find(int id) {
    return em.find(User.class, id);
  }
  public User find(String name) {
    List<User> users = em.createQuery("SELECT u FROM User u WHERE u.name = :name").setParameter("name",name).getResultList();
    if(users.isEmpty())
      return null;
    return users.get(0);
    
  }

  public List<User> findAll() {
    return em.createQuery("SELECT u FROM User u").getResultList();
  }

  public void persist(User... users) {
    em.getTransaction().begin();
    for (User user : users) {
      em.persist(user);
    }
    em.getTransaction().commit();
  }

  public void merge(User... updatedUsers) {
    em.getTransaction().begin();
    for (User user : updatedUsers) {
      em.merge(user);
    }
    em.getTransaction().commit();
  }

  public void remove(User... users) {
    em.getTransaction().begin();
    for (User user : users) {
      em.remove(user);
    }
    em.getTransaction().commit();
  }
}
