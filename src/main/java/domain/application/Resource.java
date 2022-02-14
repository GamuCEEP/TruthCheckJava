package domain.application;

import domain.user.User;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource implements Serializable{

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;
  
  @ManyToOne
  private User holder;
  @OneToOne
  private User author;
}
