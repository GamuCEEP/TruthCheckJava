package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Actor extends Resource{

  

  @ElementCollection(fetch = FetchType.EAGER)
  private Map<String, String> stats;

  
}
