package domain.application;

import domain.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 *
 * @author GamuD
 */
@Data
@MappedSuperclass
public abstract class Resource implements Serializable{
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String description;
  
  @ManyToMany
  private List<User> users;
  
  @ManyToMany
  private List<User> author;
}
