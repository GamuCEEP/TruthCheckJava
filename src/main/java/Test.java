
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
    
    User u = new User(0, "Pepe", "1234");
    
    System.out.println(SQLAssistant.getInsertValue(u));
  }

}
