package data.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
  
  private static Connection connection = null;
  private static String DB_URL = "jdbc:mysql://root@localhost:3306/"
            + "TruthCheckJava?useSSL=false&useTimeZone=true&serverTimezone=UTC&"
            + "allowPublicKeyRetrieval=true";
  
  private static void openConnection() throws SQLException{ 
    ConnectionManager.connection = DriverManager.getConnection(DB_URL);
  }
  
  public static Connection getConnection() throws SQLException{
    if(connection == null)
      openConnection();
    return ConnectionManager.connection;
  }

}
