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

  public static String getCreateDefinition(Object bean) {

    parseMethods(bean);

    return "";
  }

  private static Table buildTable(List<Field> fields) {

    return null;
  }

  private static Table buildAuxiliarTable(Object bean, Method method) {

    TableField fieldAnnotation = method.getAnnotation(TableField.class);
    
    List<String> primaryKeys = new ArrayList<>();
    List<Field> fields = new ArrayList<>();
    
    String foreignKey = 
            bean.getClass().getSimpleName().toLowerCase() + 
            "(" + fieldAnnotation.TablePrimaryKey() + ")";
    
    fields.add(new Field(
            bean.getClass().getSimpleName().toLowerCase(), 
            FieldType.valueOf("INT"), 
            true,
            false,
            foreignKey
    ));
    
    
    //TODO Ver como hacer la creacion de mapas y listas
    // Posiblemente con un if mesirva por que solo voy a usar eso
    //Si no intentar eliminar los mapas de la ecaucion
    //aunque dudo que sea posible sin overengeneer it
    for(String type : fieldAnnotation.Type().split(",")){
      fields.add(new Field(
            bean.getClass().getSimpleName().toLowerCase(), 
            FieldType.valueOf(type.trim().toUpperCase()), 
            true,
            false,
            foreignKey
    ));
    }
    
    
    
    
    
    return new Table(
            method.getName().substring(3).toLowerCase(), 
            primaryKeys,
            fields
    );
  }

  private static Field createField(String name, Method method) {

    TableField fieldAnnotation = method.getAnnotation(TableField.class);

    return new Field(
            name,
            FieldType.valueOf(fieldAnnotation.Type().toUpperCase()),
            fieldAnnotation.IsPrimaryKey(),
            fieldAnnotation.IsAutoIncremental(),
            fieldAnnotation.ForeignKey()
    );

  }

  private static List<Table> parseMethods(Object bean) {
    List<Table> tables = new ArrayList<>();
    List<Field> fields = new ArrayList<>();

    for (Method method : bean.getClass().getMethods()) {
      TableField fieldAnnotation = method.getAnnotation(TableField.class);
      if (fieldAnnotation == null) {
        continue;
      }
      if (fieldAnnotation.IsInvertedForeignKey()) {
        tables.add(buildAuxiliarTable(bean, method));
        continue;
      }
      String fieldName = method.getName().substring(3).toLowerCase();
      fields.add(createField(fieldName,method));
    }

    tables.add(buildTable(fields));

    return tables;
  }

}
