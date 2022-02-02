package data;

import domain.beans.application.Resource;
import domain.beans.application.Interaction;
import domain.beans.application.Effect;
import domain.beans.application.Item;
import java.util.ArrayList;
import java.util.List;

public class dataAPI {

    // TODO Implement the class and its methods
    public static Resource getResource(String resourceType, String id) {
      //MOCK METHOD
      return mock_getResource(resourceType, id);
      
      
      
      
    }
    
    private static Resource mock_getResource(String resourceType, String id){
      //--------------------------------------------Testing Code--------------------------------------------\\
    /**/Effect ef = new Effect(0, "Atraccion", "atrae cosas", "Resources.distance --");             
    /**/
    /**/List efs = new ArrayList<Interaction>();
    /**/efs.add(ef);
    /**/Interaction inte = new Interaction(0, "Magnetismo", "Atrae objetos metalicos", "has metal", efs);
    /**/
    /**/List intes = new ArrayList<Interaction>();
    /**/intes.add(inte);
    /**/
    /**/Item i = new Item(0, "Espada", "Es un palo", intes);
    /**/
    /**/return i;
    //--------------------------------------------Testing Code--------------------------------------------\\
    }
}
