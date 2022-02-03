package domain.beans.application;

import Annotations.TableField;

public abstract class Resource {

  private int id;
  private String name;
  private String description;

  public Resource() {
  }

  public Resource(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  @TableField(Type = "INT", IsPrimaryKey = true, IsAutoIncremental = true)
  public int getId() {
    return id;
  }
  @TableField(Type = "TEXT")
  public String getName() {
    return name;
  }
  @TableField(Type = "TEXT")
  public String getDescription() {
    return description;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
