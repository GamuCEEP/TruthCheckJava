package data.SQL;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Table {

  private String name;
  private List<TableField> fields;

  public Table(String tableName) {
    this.name = tableName;
    fields = new ArrayList<>();
  }

  public String getCreateDefinition() {
    StringBuilder sb = new StringBuilder();

    return formatValues(fields);
  }

  public String formatValues(Iterable<?> values) {

    StringBuilder result = new StringBuilder();

    for (Object value : values) {
      if (!result.isEmpty()) {
        result.append(',');
      }
      result.append(value.toString());
    }

    return result.toString();
  }

  //<editor-fold defaultstate="collapsed" desc="Overloading of Field Creation">
  public void addField(
          String fieldName,
          FieldType type,
          boolean isAutoIncremental,
          boolean isPrimaryKey,
          String references
  ) {
    fields.add(new TableField(fieldName, type, isAutoIncremental, isPrimaryKey,
            references));
  }

  public void addField(
          String fieldName,
          FieldType type,
          boolean isAutoIncremental,
          boolean isPrimaryKey
  ) {
    addField(fieldName, type, isAutoIncremental, isPrimaryKey, "");
  }

  public void addField(
          String fieldName,
          FieldType type,
          String references
  ) {
    fields.add(new TableField(fieldName, type, false, false,
            references));
  }

  public void addField(
          String fieldName,
          FieldType type
  ) {
    addField(fieldName, type, false, false, "");
  }
  //</editor-fold>

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

    @Override
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
      if (isPrimaryKey) {
        sb.append("PRIMARY KEY").append(' ');
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
