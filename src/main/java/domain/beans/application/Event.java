package domain.beans.application;

import Annotations.TableField;
import java.util.ArrayList;
import java.util.List;

public class Event extends Resource {

  private List<Effect> effects;
  private int probability;
  private int priority;

  public Event() {
    effects = new ArrayList<>();
  }

  public Event(int id, String name, String description) {
    super(id, name, description);
    effects = new ArrayList<>();
  }

  public Event(List<Effect> effects, int probability, int priority, int id, String name, String description) {
    super(id, name, description);
    this.effects = effects;
    this.probability = probability;
    this.priority = priority;
  }

  @TableField(Type = "INT", IsInvertedForeignKey = true, ForeignKey = "effect(id)")
  public List<Effect> getEffects() {
    return effects;
  }

  @TableField(Type = "INT")
  public int getPriority() {
    return priority;
  }

  @TableField(Type = "FLOAT")
  public int getProbability() {
    return probability;
  }

  public void setEffects(List<Effect> effects) {
    this.effects = effects;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public void setProbability(int probability) {
    this.probability = probability;
  }

}
