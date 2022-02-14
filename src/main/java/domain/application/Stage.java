package domain.application;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Stage extends Resource {
  
  @OneToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Event> timeline;

}
