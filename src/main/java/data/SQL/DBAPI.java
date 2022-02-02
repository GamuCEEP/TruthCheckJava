package data.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAPI {

  //DB MANAGEMENT
  private final String CREATE_TABLE = "CREATE TABLE ? ( ? )";

  //CRUD
  private final String INSERT = "INSERT INTO ? VALUES( ? )";
  private final String SELECT = "SELECT ? FROM ?";
  private final String UPDATE = "UPDATE TABLE ? SET ?";
  private final String DELETE = "DELETE FROM ?";

  //FILTERS
  private final String FILTER = "WHERE ?";

  private boolean executeQuery(String queryType, String... data) throws SQLException {
    Connection con = ConnectionManager.getConnection();

    PreparedStatement stm = con.prepareStatement(queryType);

    for (int i = 0; i < data.length; i++) {
      stm.setString(i, data[i]);
    }

    return stm.execute();
  }
  
  private boolean mock_executeQuery(String queryType, String... data){
    StringBuilder sb = new StringBuilder();
    
    sb.append(queryType);
    for(String a : data){
      sb.replace(sb.indexOf("?"), sb.indexOf("?") + 1, a);
    }
    System.out.println(sb.toString());
    return false;
  }

  public boolean createTable(Table table) throws SQLException {
    return mock_executeQuery(CREATE_TABLE, table.toSQLString());
  }

  public boolean insert(String tableName, String data) throws SQLException {
    Connection con = ConnectionManager.getConnection();
    return false;
  }

}
