
import java.util.HashMap;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {        
        
        JSONObject test = new JSONObject();
        test.put("badRequests", 2);
        test.accumulate("badRequests",3);
        
        test.put("actors", new JSONArray());
        test.getJSONArray("actors").put((new JSONObject()).put("id", 3));
        test.getJSONArray("actors").put((new JSONObject()).put("id", 2));
        
        System.out.println(test);
    }
}
