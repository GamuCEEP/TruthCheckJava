
package domain.beans.Objects;

import domain.beans.Interactions.Interaction;
import domain.beans.Resource;
import java.util.ArrayList;
import java.util.List;

public class Item extends Resource{
    
    private List<Interaction> interactions;
    
    public Item(){}
    
    public Item(int id, String name, String description, List<Interaction> interactions) {
        super(id, name, description);
        this.interactions = interactions;
    }
    public Item(int id, String name, String description) {
        super(id, name, description);
        this.interactions = new ArrayList<>();
    }  

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }
    
}
