package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Event extends Resource {



  @ManyToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Effect> effects;
  private int priority;


}
