package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Event extends Resource {

  private List<Effect> effects;
  private int priority;

  public Event() {
    effects = new ArrayList<>();
  }

  public Event(int id, String name, String description) {
    super(id, name, description);
    effects = new ArrayList<>();
  }

  public Event(List<Effect> effects, int priority, int id, String name, String description) {
    super(id, name, description);
    this.effects = effects;
    this.priority = priority;
  }

  public List<Effect> getEffects() {
    return effects;
  }

  public int getPriority() {
    return priority;
  }

  public void setEffects(List<Effect> effects) {
    this.effects = effects;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

}
