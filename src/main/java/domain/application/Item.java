package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
public class Item extends Resource  {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;

  @OneToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Interaction> interactions;

  @ManyToMany
  List<User> users;

}
