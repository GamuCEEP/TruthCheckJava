package data.SQL;

import java.util.ArrayList;
import java.util.List;

public class Table {

  protected String name;
  protected List<String> primaryKeys;
  protected List<Field> fields;
  
  public Table(String name){
    this.name = name;
  }

  public Table(String name, List<Field> fields) {
    this.name = name;
    this.primaryKeys = new ArrayList<>();
    this.fields = fields;
    loadPrimaryKeys();
  }
  
  public Field getField(String name){
    for(Field field : fields){
      if(field.name.equals(name)){
        return field;
      }
    }
    return null;
  }
  
  public void loadPrimaryKeys(){
    for(Field field : fields){
      if(field.isPrimaryKey)
        primaryKeys.add(field.name);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append(name).append('(');
    sb.append(SQLAssistant.formatValueList(fields)).append(',');
    sb.append("primary key (").append(SQLAssistant.formatValueList(primaryKeys));
    sb.append(')');
    sb.append(')');
    
    return sb.toString();
  }
  
  

  
}
