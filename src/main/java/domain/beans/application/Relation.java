package domain.beans.application;

import Annotations.TableField;
import java.util.ArrayList;
import java.util.List;

public class Relation extends Resource {

  private List<Effect> effects;

  public Relation() {
    effects = null;
    effects = new ArrayList<>();
  }

  public Relation(int id, String name, String description) {
    super(id, name, description);
    effects = new ArrayList<>();
  }

  public Relation(int id, String name, String description, List<Effect> effects) {
    super(id, name, description);
    this.effects = effects;
  }

  @TableField(Type = "INT", IsInvertedForeignKey = true, ForeignKey = "effect(id)")
  public List<Effect> getEffect() {
    return effects;
  }

  public void setEffect(List<Effect> effects) {
    this.effects = effects;
  }

}
