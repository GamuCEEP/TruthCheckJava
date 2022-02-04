package data.SQL;

import Annotations.TableField;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains tools to transform between SQL and java Beans
 */
public class SQLAssistant {

  public static List<String> getCreateDefinitions(Object bean) {  

    List<String> createDefinitions = new ArrayList<>();
    for(Table table : parseMethods(bean)){
      createDefinitions.add(table.toString());
    }
    return createDefinitions;
  }

  private static Table buildTable(List<Field> fields) {
    System.out.println("Implementa esto monoooo");
    //TODO hay que acabar esto jiji
    return null;
  }

  private static Table buildAuxiliarTable(Table mainTable, Method method) {

    TableField fieldAnnotation = method.getAnnotation(TableField.class);

    Table auxTable = new Table(method.getName().substring(3).toLowerCase());

    if (fieldAnnotation.Type().split(",").length == 1) {
      fillListAuxTable(mainTable, method, auxTable);
    } else {
      fillMapAuxTable(mainTable, method, auxTable);
    }

    return auxTable;
  }

  private static void fillMapAuxTable(Table mainTable, Method method,
          Table auxTable) {
    TableField fieldAnnotation = method.getAnnotation(TableField.class);
    
    fillAuxPrimaryFields(mainTable, auxTable);
    
    auxTable.primaryKeys.add("key");
    auxTable.fields.add(new Field(
            "key",
            FieldType.valueOf(fieldAnnotation.Type().split(",")[0].trim().toUpperCase()),
            true,
            false,
            ""
    ));
    auxTable.fields.add(new Field(
            "value",
            FieldType.valueOf(fieldAnnotation.Type().split(",")[1].trim().toUpperCase()),
            false,
            false,
            ""
    ));
  }

  private static void fillListAuxTable(Table mainTable, Method method,
          Table auxTable) {

    TableField fieldAnnotation = method.getAnnotation(TableField.class);

    fillAuxPrimaryFields(mainTable, auxTable);

    auxTable.fields.add(new Field(
            "value",
            FieldType.valueOf(fieldAnnotation.Type().trim().toUpperCase()),
            false,
            false,
            ""
    ));
  }

  private static void fillAuxPrimaryFields(Table mainTable, Table auxTable) {
    for (String primaryKey : mainTable.primaryKeys) {
      auxTable.fields.add(new Field(
              mainTable.name + "_" + primaryKey,
              mainTable.getField(primaryKey).type,
              true,
              false,
              mainTable.name + "(" + primaryKey + ")"
      ));
      auxTable.primaryKeys.add(mainTable.name + "_" + primaryKey);
    }
  }

  private static Field createField(Method method) {
    TableField fieldAnnotation = method.getAnnotation(TableField.class);

    return new Field(
            method.getName().substring(3).toLowerCase(),
            FieldType.valueOf(fieldAnnotation.Type().toUpperCase()),
            fieldAnnotation.IsPrimaryKey(),
            fieldAnnotation.IsAutoIncremental(),
            fieldAnnotation.ForeignKey()
    );

  }

  private static List<Table> parseMethods(Object bean) {
    List<Table> tables = new ArrayList<>();
    List<Field> fields = new ArrayList<>();

    List<Method> methodsForAux = new ArrayList<>();

    for (Method method : bean.getClass().getMethods()) {
      TableField fieldAnnotation = method.getAnnotation(TableField.class);
      if (fieldAnnotation == null) {
        continue;
      }
      if (fieldAnnotation.IsInvertedForeignKey()) {
        methodsForAux.add(method);
        continue;
      }
      fields.add(createField(method));
    }
    Table mainTable = buildTable(fields);
    tables.add(mainTable);

    for (Method m : methodsForAux) {
      tables.add(buildAuxiliarTable(mainTable, m));
    }

    return tables;
  }

  public static String formatValueList(List<?> values) {
    StringBuilder sb = new StringBuilder();
    for (Object value : values) {
      if (sb.length() != 0) {
        sb.append(',');
      }
      sb.append(value.toString());
    }
    return sb.toString();
  }
}
