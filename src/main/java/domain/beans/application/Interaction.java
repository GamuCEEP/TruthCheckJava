package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Interaction extends Resource {

    private String trigger;
    private List<Effect> effects;

    public Interaction() {
        effects = new ArrayList<>();
    }

    public Interaction(int id, String name, String description) {
        super(id, name, description);
        trigger = "";
        effects = new ArrayList<>();
    }

    public Interaction(int id, String name, String description, String trigger, List<Effect> effects) {
        super(id, name, description);
        this.trigger = trigger;
        this.effects = effects;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effect) {
        this.effects = effect;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

}
