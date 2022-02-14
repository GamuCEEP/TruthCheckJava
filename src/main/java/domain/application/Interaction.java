package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
public class Interaction implements Serializable, Resource {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;

  private String triggerer;
  @OneToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Effect> effects;

  @ManyToMany
  List<User> users;
}
