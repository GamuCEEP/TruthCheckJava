
import data.DAOs.application.ActorDAO;
import data.DAOs.user.UserDAO;
import domain.beans.application.Actor;
import domain.beans.user.User;
import java.sql.SQLException;
import javax.persistence.*;

public class Test {

  public static void main(String[] args) throws SQLException {

    ActorDAO a = new ActorDAO();
    
    a.persist(new Actor());
    
    System.out.println(a.find(1));
    System.out.println(a.findAll());
    
  }

}
