package domain.beans.application;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public abstract class Resource {

  private int id;
  private String name;
  private String description;

  public Resource() {
  }

  public Resource(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
