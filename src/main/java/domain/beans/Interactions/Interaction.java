package domain.beans.Interactions;

import domain.beans.Resource;

public class Interaction extends Resource {
    
    private String trigger;
    private Effect effect;
    
    public Interaction(){}

    public Interaction(int id, String name, String description) {
        super(id, name, description);
        trigger = "";
        effect = null;
    }
    
    public Interaction(int id, String name, String description, String trigger, Effect effect) {
        super(id, name, description);
        this.trigger = trigger;
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    
    
}
