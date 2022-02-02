package data.SQL;

import java.util.ArrayList;
import java.util.List;

public class Table {

  private String tableName;
  private List<TableField> fields;

  public Table(String tableName) {
    this.tableName = tableName;
    fields = new ArrayList<>();
  }

  public String[] toSQLString() {
    StringBuilder sb = new StringBuilder();

    for (TableField field : fields) {
      if (sb.length() != 0) {
        sb.append(',');
      }
      sb.append(field.toString());
    }

    return new String[]{tableName, sb.toString()};
  }

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

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public List<TableField> getFields() {
    return fields;
  }

  public void setFields(List<TableField> fields) {
    this.fields = fields;
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
        sb.append("REFERENCES ").append(references);
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
