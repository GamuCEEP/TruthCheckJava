package data.SQL;

import Annotations.TableField;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains tools to transform between SQL and java Beans
 */
public class SQLAssistant {
  
  /*TODO IMPORTANT STRUCTURAL
    los campos de los bean que sean colecciones(list Map) deberian estar en otra clase:
    
      List<Item> inventario ---> Inventario inventario
  
    por lo que las relacion se invierte, en vez de la tabla pincipal cede su clave es la secundaria,
    para ello la clave principal de las tablas secundarias esta compuesta por una id repetida para cada
    elemento del grupo + el elemento del grupo, esencialmente son sets
     id val
    | 1|espada
    | 1|escudo
    | 1|casco
    
    no ideal pero facilita el desarrollo asi que...
  */

  public static List<String> getCreateDefinitions(Object bean) {

    List<String> createDefinitions = new ArrayList<>();
    for (Table table : parseMethods(bean)) {
      createDefinitions.add(table.toString());
    }
    return createDefinitions;
  }

  public static List<Table> getTables(Object bean) {
    return parseMethods(bean);
  }

  public static String getTableName(Object bean) {
    return bean.getClass().getSimpleName().toLowerCase();
  }

  public static String getInsertValue(Object bean) {
    StringBuilder sb = new StringBuilder();

    for (Method m : getGetterMethods(bean)) {
      String field = getFieldName(m);
      if (!sb.toString().isEmpty()) {
        sb.append(",");
      }
      try {
        sb.append(field).append('=');
        sb.append("'").append(m.invoke(bean)).append("'");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

  public static String getFilter(Object bean) {
    List<Method> getId = getGetterMethods(bean);
    getId.removeIf(m -> {
      return !m.getName().equals("getId");
    });
    
    try {
      return "id='" + getId.get(0).invoke(bean)+"'";
    } catch (Exception e) {}
    
    return null;
  }

  public static String getFieldName(Method method) {
    return method.getName().substring(3).toLowerCase();
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

    auxTable.fields.add(new Field(
            "key",
            FieldType.valueOf(
                    fieldAnnotation.Type().split(",")[0].trim().toUpperCase()),
            true,
            false,
            ""
    ));
    auxTable.fields.add(new Field(
            "val",
            FieldType.valueOf(
                    fieldAnnotation.Type().split(",")[1].trim().toUpperCase()),
            false,
            false,
            fieldAnnotation.ForeignKey()
    ));
    auxTable.loadPrimaryKeys();
  }

  private static void fillListAuxTable(Table mainTable, Method method,
          Table auxTable) {

    TableField fieldAnnotation = method.getAnnotation(TableField.class);

    fillAuxPrimaryFields(mainTable, auxTable);

    auxTable.fields.add(new Field(
            "val",
            FieldType.valueOf(fieldAnnotation.Type().trim().toUpperCase()),
            false,
            false,
            fieldAnnotation.ForeignKey()
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
            getFieldName(method),
            FieldType.valueOf(fieldAnnotation.Type().toUpperCase()),
            fieldAnnotation.IsPrimaryKey(),
            fieldAnnotation.IsAutoIncremental(),
            fieldAnnotation.ForeignKey()
    );

  }

  private static List<Method> getGetterMethods(Object bean) {
    List<Method> methods = new ArrayList<>();
    methods.addAll(Arrays.asList(bean.getClass().getMethods()));

    methods.removeIf(m -> {
      TableField fieldAnnotation = m.getAnnotation(TableField.class);
      return fieldAnnotation == null;
    });

    methods.sort((m1, m2) -> {
      return m1.getName().compareTo(m2.getName());
    });

    return methods;
  }

  private static List<Method> getSetterMethods(Object bean) {
    List<Method> methods = new ArrayList<>();
    methods.addAll(Arrays.asList(bean.getClass().getMethods()));
    methods.removeIf(m -> {
      return !m.getName().startsWith("set");
    });
    methods.sort((m1, m2) -> {
      return m1.getName().compareTo(m2.getName());
    });
    return methods;
  }

  private static List<Table> parseMethods(Object bean) {
    List<Table> tables = new ArrayList<>();
    List<Field> fields = new ArrayList<>();

    List<Method> methodsForAux = new ArrayList<>();

    for (Method method : getGetterMethods(bean)) {
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

    Table mainTable = new Table(getTableName(bean));
    mainTable.setFields(fields);
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
