package domain.beans.application;

import Annotations.TableField;
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
    effects = new ArrayList<>();
  }

  public Interaction(int id, String name, String description, String trigger, List<Effect> effects) {
    super(id, name, description);
    this.trigger = trigger;
    this.effects = effects;
  }

  @TableField(Type = "INT", IsInvertedForeignKey = true, ForeignKey = "effect(id)")
  public List<Effect> getEffects() {
    return effects;
  }

  @TableField(Type = "TEXT")
  public String getTrigger() {
    return trigger;
  }

  public void setEffects(List<Effect> effect) {
    this.effects = effect;
  }

  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }

}
