
import data.DAOs.user.UserDAO;
import domain.beans.user.User;
import java.sql.SQLException;
import javax.persistence.*;

public class Test {

  public static void main(String[] args) throws SQLException {

    Test t = new Test();

    UserDAO u = new UserDAO();

    u.insert(new User("Oscar", "Jiji"));
    u.insert(new User("Cami", "1234"));
    u.insert(new User("iker", "weff"));

    for (User user : u.selectAll()) {
      System.out.println(user);
    }
    System.out.println("Busqueda por nombre ___");
    System.out.println(u.select("Cami"));
    System.out.println("Busqueda por id ___");
    System.out.println(u.select("pepe"));

  }

}
