
import domain.beans.application.Interaction;
import domain.beans.application.Effect;
import domain.beans.application.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.RestAPI.ResourceType;
import org.json.JSONObject;

public class Test {

  public static void main(String[] args) {

    Effect ef = new Effect(0, "Atraccion", "atrae cosas", "Resources.distance --");

    List efs = new ArrayList<Interaction>();
    efs.add(ef);
    Interaction inte = new Interaction(0, "Magnetismo", "Atrae objetos metalicos", "has metal", efs);

    List intes = new ArrayList<Interaction>();
    intes.add(inte);

    Item i = new Item(0, "Espada", "Es un palo", intes);

    JSONObject test = new JSONObject();
    test.accumulate("Items", i);
    List<List<Item>> lliisstt = new ArrayList<>();

    List<Item> listItem = new ArrayList<>();

    listItem.add(i);

    lliisstt.add(listItem);
    lliisstt.add(listItem);
    lliisstt.add(listItem);

    JSONObject lislist = new JSONObject();
    lislist.accumulate("Timeline", lliisstt);

    System.out.println(lislist.toString(1));
    System.out.println("Hola");

  }

  static JSONObject getActorJSON(String id) {
    return new JSONObject().put("nombre", "recurso");
  }
}
