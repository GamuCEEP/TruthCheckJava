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
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.Arrays;

public class Test {

  public static void main(String[] args) throws SQLException {

    Actor a = new Actor();

    List<Method> methods = new ArrayList<>();
    methods.addAll(Arrays.asList(a.getClass().getMethods()));
    
    FieldType f = FieldType.valueOf("TEXT");
    
    System.out.println(f);

  }

}
