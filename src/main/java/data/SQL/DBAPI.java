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

  private void executeQuery(String queryType, String... data) throws SQLException {
    Connection con = ConnectionManager.getConnection();

    String sql = buildQueryString(queryType, data);

    PreparedStatement stm = con.prepareStatement(sql);

    stm.execute();
  }

  private String buildQueryString(String queryType, String... params) {
    StringBuilder sql = new StringBuilder(queryType);
    for (String param : params) {
      sql.replace(sql.indexOf("?"), sql.indexOf("?") + 1, param);
    }
    return sql.toString();
  }

  public void createTable(Table table) throws SQLException {
    executeQuery(CREATE_TABLE, table.getName(), table.getCreateDefinition());
  }

  public void insert(Table table, String values) throws SQLException {
    executeQuery(INSERT, table.getName(), values);
  }
  //TODO continue with CRUD operations
  

}
