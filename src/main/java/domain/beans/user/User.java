package domain.beans.user;

import domain.beans.application.Resource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@Data
public class User implements Serializable {
  
  
  @Id
  @GeneratedValue
  private int id;
  private String name;
  /**
   * A hashed version of the password the user suplied
   */
  private String password;
  
  @OneToMany(mappedBy = "holder")
  private List<Resource> library;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
}
