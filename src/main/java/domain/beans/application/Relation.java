package domain.beans.application;

public class Relation extends Resource {

  private Effect effect;

  public Relation() {
    effect = null;
  }

  public Relation(int id, String name, String description) {
    super(id, name, description);
    effect = null;
  }

  public Relation(int id, String name, String description, Effect effect) {
    super(id, name, description);
    this.effect = effect;
  }

  public Effect getEffect() {
    return effect;
  }

  public void setEffect(Effect effect) {
    this.effect = effect;
  }

}
