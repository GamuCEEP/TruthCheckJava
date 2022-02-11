package domain.beans.application;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Map extends Resource {

  @OneToMany
  @ElementCollection(fetch = FetchType.EAGER)
  private List<Stage> zones;
}
