package data.SQL;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLConnection {
  
  private Connection connection = null;
  
  private SQLConnection(){ 
    //TODO AAAAAAAAAAAAAA NO SE COMO FUNCIONA :(
    this.connection = DriverManager.getConnection("jdbc:mysql://localhost");
  
  }
  
  public 

}
