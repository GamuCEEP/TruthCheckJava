
import data.DAOs.user.UserDAO;
import domain.beans.user.User;
import java.sql.SQLException;
import javax.persistence.*;

public class Test {

  @PersistenceUnit(name = "TruthCheckJava")
  public EntityManagerFactory emf;
  @PersistenceContext(unitName = "TruthCheckJava")
  public EntityManager em;

  public Test() {
    emf = Persistence.createEntityManagerFactory("TruthCheckJava");
    em = emf.createEntityManager();
  }

  public static void main(String[] args) throws SQLException {

    Test t = new Test();

    UserDAO u = new UserDAO(t.em);

    u.insert(new User("Oscar", "Jiji"));
    u.insert(new User("Cami", "1234"));
    u.insert(new User("Cami", "weff"));

    for (User user : u.selectAll()) {
      System.out.println(user);
    }
    System.out.println("Busqueda por nombre ___");
    System.out.println(u.select("Cami"));
    System.out.println("Busqueda por id ___");
    System.out.println(u.select(1,2));

  }

}
