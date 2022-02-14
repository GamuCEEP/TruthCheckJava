
import data.DAOs.application.ActorDAO;
import data.DAOs.user.UserDAO;
import domain.beans.application.Actor;
import domain.beans.user.User;
import javax.inject.Inject;
import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) throws SQLException {

    ActorDAO a = new ActorDAO();
    
    Actor ac = new Actor();

    ac.setName("Antonio");
    ac.setDescription("La piedra mas valiente del reino");
    Map<String, String> stats = new HashMap<>();
    stats.put("Vida", "100");
    stats.put("Ataque", "999");
    stats.put("Defensa", "999");

    ac.setStats(stats);

    
    a.persist(ac);

    System.out.println(a.find(1));
    System.out.println(a.findAll());

  }

}
