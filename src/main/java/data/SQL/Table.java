package data.SQL;

import java.util.List;

public class Table {

  protected String name;
  protected List<String> primaryKeys;
  protected List<Field> fields;

  public Table(String name, List<String> primaryKeys, List<Field> fields) {
    this.name = name;
    this.primaryKeys = primaryKeys;
    this.fields = fields;
  }

  
}
