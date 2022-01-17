
package domain.Objects;

import domain.Interactions.Interaction;
import domain.Resource;
import java.util.ArrayList;
import java.util.List;

public class Item extends Resource{
    
    private final List<Interaction> interactions;
    public Item(int id, String name, String description, List<Interaction> interactions) {
        super(id, name, description);
        this.interactions = interactions;
    }
    public Item(int id, String name, String description) {
        super(id, name, description);
        this.interactions = new ArrayList<>();
    }
    
    
    
}
