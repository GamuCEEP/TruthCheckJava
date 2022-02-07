
import Annotations.TableField;
import domain.beans.application.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.RestAPI.ResourceType;
import org.json.JSONObject;
import data.SQL.*;
import domain.beans.application.*;
import domain.beans.user.User;
import java.sql.SQLException;
import java.util.Arrays;

public class Test {

  public static void main(String[] args) throws SQLException {
    
    User u1 = new User();
    u1.setId(394);
    u1.setName("pepe");
    u1.setPassword("12344");
    
    // Ya esta casi acabada DBAPI creo que van a sobrar capas
    DBAPI.delete(u1);
  }

}
