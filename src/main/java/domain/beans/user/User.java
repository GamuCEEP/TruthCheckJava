package domain.beans.user;

public class User {

  private int id;
  private String name;
  /**
   * A hashed version of the password the user suplied
   */
  private String password;

  public User() {
  }

  public User(int id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
