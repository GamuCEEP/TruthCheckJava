package domain.beans.user;

import Annotations.TableField;

public class User {

  private Integer id;
  private String name;
  /**
   * A hashed version of the password the user suplied
   */
  private String password;

  public User() {
  }

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  @TableField(Type = "INT", IsPrimaryKey = true, IsAutoIncremental = true)
  public Integer getId() {
    return id;
  }

  @TableField(Type = "TEXT")
  public String getName() {
    return name;
  }
  
  @TableField(Type = "TEXT")
  public String getPassword() {
    return password;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
