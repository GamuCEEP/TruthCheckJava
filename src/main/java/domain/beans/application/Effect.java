package domain.beans.application;

import javax.persistence.Entity;
import lombok.*;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Effect extends Resource {

  private String code;
}
