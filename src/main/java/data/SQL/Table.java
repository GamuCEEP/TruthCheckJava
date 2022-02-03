package data.SQL;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Table {

  private String name;
  private List<String> fields;
  private List<String> primaryKeys;

  public Table(String tableName) {
    this.name = tableName;
    fields = new ArrayList<>();
    primaryKeys = new ArrayList<>();
  }
  
  //TODO Organizar bien como funciona todo esto (dibujos)

  //<editor-fold defaultstate="collapsed" desc="Overloading of Field Creation">
  public Table addField(
          String fieldName,
          FieldType type,
          boolean isAutoIncremental,
          boolean isPrimaryKey,
          String references
  ) {

    TableField field = new TableField(fieldName, type, isAutoIncremental,
            isPrimaryKey, references);
    fields.add(field.toString());
    if(field.isPrimaryKey){
      primaryKeys.add(field.fieldName);
    }
    return this;
  }

  public Table addField(
          String fieldName,
          FieldType type,
          boolean isAutoIncremental,
          boolean isPrimaryKey
  ) {
    return addField(fieldName, type, isAutoIncremental, isPrimaryKey, "");
  }

  public Table addField(
          String fieldName,
          FieldType type,
          String references
  ) {
    return addField(fieldName, type, false, false, references);
  }

  public Table addField(
          String fieldName,
          FieldType type
  ) {
    return addField(fieldName, type, false, false, "");
  }
  //</editor-fold>

  public String getName() {
    return name;
  }

  public List<String> getFields() {
    return fields;
  }

  private class TableField {

    public String fieldName;
    public FieldType type;
    public boolean isAutoIncremental;
    public boolean isPrimaryKey;
    public String references;

    public TableField() {
    }

    public TableField(String fieldName, FieldType type,
            boolean isAutoIncremental, boolean isPrimaryKey, String references) {
      this.fieldName = fieldName;
      this.type = type;
      this.isAutoIncremental = isAutoIncremental;
      this.isPrimaryKey = isPrimaryKey;
      /**
       * @Format: "table(field)"
       */
      this.references = references;
    }

    //@Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append(fieldName).append(' ');

      sb.append(type);
      if (type == FieldType.VARCHAR) {
        sb.append("(100)");
      }
      sb.append(' ');

      if (isAutoIncremental) {
        sb.append("AUTO_INCREMENT").append(' ');
      }
      if (!references.isEmpty()) {
        sb.append(',');
        sb.append("FOREIGN KEY(").append(fieldName);
        sb.append(") REFERENCES ").append(references);
      }
      return sb.toString();
    }
  }

  public enum FieldType {
    VARCHAR,
    FLOAT,
    INT,
    BOOLEAN;

  }
}
