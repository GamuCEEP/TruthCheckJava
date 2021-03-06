package domain.application;

import java.util.Map;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Actor extends Resource {

  @ElementCollection(fetch = FetchType.EAGER)
  private Map<String, String> stats;
}
