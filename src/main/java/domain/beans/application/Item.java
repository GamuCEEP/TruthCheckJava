package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Item extends Resource {

  private List<Interaction> interactions;

  public Item() {
    this.interactions = new ArrayList<>();
  }

  public Item(int id, String name, String description) {
    super(id, name, description);
    this.interactions = new ArrayList<>();
  }

  public Item(int id, String name, String description, List<Interaction> interactions) {
    super(id, name, description);
    this.interactions = interactions;
  }
  
  public List<Interaction> getInteractions() {
    return interactions;
  }

  public void setInteractions(List<Interaction> interactions) {
    this.interactions = interactions;
  }

}
