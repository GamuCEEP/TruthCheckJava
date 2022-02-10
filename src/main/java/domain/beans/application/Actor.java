package domain.beans.application;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Actor extends Resource {

  private Map<String, String> stats;

  public Actor() {
    this.stats = new HashMap<>();
  }

  public Actor(int id, String name, String description) {
    super(id, name, description);
    this.stats = new HashMap<>();
  }

  public Actor(int id, String name, String description, Map<String, String> stats) {
    super(id, name, description);
    this.stats = stats;
  }


}
