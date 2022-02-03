
import domain.beans.application.Interaction;
import domain.beans.application.Effect;
import domain.beans.application.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.RestAPI.ResourceType;
import org.json.JSONObject;
import data.SQL.*;
import java.sql.SQLException;

public class Test {

  public static void main(String[] args) throws SQLException {

    Table t = new Table("borrame");

    t.addField("id", Table.FieldType.INT, true, true);
    t.addField("nombre", Table.FieldType.VARCHAR);
    t.addField("password", Table.FieldType.VARCHAR);
    t.addField("master", Table.FieldType.INT, "t1(id)");
    t.addField("patata", Table.FieldType.BOOLEAN);

    System.out.println(t.getFields());
    DBAPI a = new DBAPI();
    
    a.createTable(t);
    

  }

}
