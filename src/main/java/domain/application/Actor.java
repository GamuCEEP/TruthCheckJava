package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
public class Actor extends Resource{

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;

  @ElementCollection(fetch = FetchType.EAGER)
  private Map<String, String> stats;

  @ManyToMany
  List<User> users;
}
