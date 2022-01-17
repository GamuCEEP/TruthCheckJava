
import java.util.HashMap;
import java.util.Hashtable;

public class Test {

    public static void main(String[] args) {

        HashMap<Integer, String> table = new HashMap<>();
        
        table.put(1, "Hola");
        table.put(2, "Oscar");
        table.put(1, "Adios");
        
        table.forEach((e,i) -> System.out.println(e + " = "+ i));
        for(Integer index : table.keySet()){
            
            //System.out.println(table.get(1));
            //System.out.println("*-"+index);
        }
        
        
        
    }
}
