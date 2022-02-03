package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TableField{
  boolean IsPrimaryKey() default false;
  boolean IsAutoIncremental() default false;
  String ForeignKey() default "";
  /**
   * Used to deal with compound types with no table representation
   * for example: list or map
   */
  boolean IsInvertedForeignKey() default false;
  String TablePrimaryKey() default "";
  String Type();
  
}
