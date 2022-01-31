
import java.util.HashMap;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {        
        
        JSONObject test = new JSONObject();
        test.put("badRequests", 2);
        test.accumulate("badRequests",3);
      
        String[] ids = {"1","2","3","4"};
        //test.put("actors", new JSONObject());
        //Lo de dentro de serveActors
        if(!test.has("actors")){
            test.put("actors", new JSONObject());
        }
        
        for(String id : ids){
            test.getJSONObject("actors").accumulate(id, getActorJSON(id));
        }
        
        
        
        System.out.println(test.toString(3));
    }
    static JSONObject getActorJSON(String id){
        return new JSONObject().put("nombre", "recurso");
    }
}
