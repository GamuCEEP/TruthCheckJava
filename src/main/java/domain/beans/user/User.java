package domain.beans.user;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@Data
@XmlRootElement
public class User {
  
  
  @Id
  @GeneratedValue
  private int id;
  private String name;
  /**
   * A hashed version of the password the user suplied
   */
  private String password;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
}
