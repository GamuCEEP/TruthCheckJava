package domain.application;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.*;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Effect extends Resource {

  private String code;
}
