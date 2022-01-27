
package domain.beans.Interactions;

import domain.beans.Resource;
import java.util.HashMap;
import java.util.Map;

public class Event extends Resource{
    
    private Map<Effect, Float> posibleEffects;
    
    public Event(){}
    
    public Event(int id, String name, String description) {
        super(id, name, description);
        posibleEffects = new HashMap<>();
    }
    public Event(int id, String name, String description, Map<Effect, Float> posibleEffects) {
        super(id, name, description);
        this.posibleEffects = posibleEffects;
    }

    public Map<Effect, Float> getPosibleEffects() {
        return posibleEffects;
    }

    public void setPosibleEffects(Map<Effect, Float> posibleEffects) {
        this.posibleEffects = posibleEffects;
    }
    
    
    
}
