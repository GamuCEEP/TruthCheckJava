package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
public class Event implements Serializable, Resource {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;

  @ManyToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Effect> effects;
  private int priority;

  @ManyToMany
  List<User> users;

}
