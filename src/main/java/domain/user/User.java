package domain.user;

import domain.application.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  /**
   * A hashed version of the password the user suplied
   */
  private String password;

  @ManyToMany
  private List<Actor> actorLibrary;
  @ManyToMany
  private List<Effect> effectLibrary;
  @ManyToMany
  private List<Event> eventLibrary;
  @ManyToMany
  private List<Interaction> interactionLibrary;
  @ManyToMany
  private List<Item> itemLibrary;
  @ManyToMany
  private List<Map> mapLibrary;
  @ManyToMany
  private List<Relation> relationLibrary;
  @ManyToMany
  private List<Stage> stageLibrary;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
}
