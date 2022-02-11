package domain.beans.application;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Resource implements Serializable{

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;
}
