
package domain.beans.application;

import java.util.HashMap;
import java.util.Map;

public class Event extends Resource{
    // TODO cambiar esto para que sea pasable a json
    private Map<Effect, Float> posibleEffects;
    
    public Event(){
        posibleEffects = new HashMap<>();
    }
    
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
