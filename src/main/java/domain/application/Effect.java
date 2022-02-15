package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
public class Effect extends Resource {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;

  private String code;

  @ManyToMany
  private List<Event> Events;

  @ManyToMany
  List<User> users;

}
