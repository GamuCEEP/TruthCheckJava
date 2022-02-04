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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append(name).append(' ');
    sb.append(type).append(' ');
    if(isAutoIncremental)
      sb.append("auto_increment").append(' ');
    if(!foreignKey.isEmpty()){
      sb.append(',');
      sb.append("foreign key").append(' ');
      sb.append("(").append(name).append(") ");
      sb.append("references ").append(foreignKey);
    }
      
    return sb.toString();
  }
  
  

}
