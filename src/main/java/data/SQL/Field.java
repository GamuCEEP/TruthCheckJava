package data.SQL;


public class Field {

  String name;
  boolean isPrimaryKey;
  boolean isAutoIncremental;
  String foreignKey;
  FieldType type;

  public Field(String name, FieldType type, boolean isPrimaryKey, boolean isAutoIncremental, String foreignKey) {
    this.name = name;
    this.type = type;
    this.isPrimaryKey = isPrimaryKey;
    this.isAutoIncremental = isAutoIncremental;
    this.foreignKey = foreignKey;
  }

}
