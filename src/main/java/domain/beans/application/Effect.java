package domain.beans.application;

import Annotations.TableField;

public class Effect extends Resource {

  private String code;

  public Effect() {
  }

  public Effect(int id, String name, String description) {
    super(id, name, description);
  }

  public Effect(int id, String name, String description, String code) {
    super(id, name, description);
    this.code = code;
  }

  @TableField(Type = "TEXT")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
