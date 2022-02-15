package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Relation extends Resource{

  
  @OneToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Effect> effects;

 
}
