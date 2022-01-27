
package domain.beans.Interactions;

import domain.beans.Resource;

public class Relation extends Resource{

    private Effect effect;

    public Relation() {}
    
    public Relation(int id, String name, String description) {
        super(id, name, description);
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
    
    
}
