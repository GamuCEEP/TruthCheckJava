package data.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAPI {

  //DB MANAGEMENT
  private static final String CREATE_TABLE = "CREATE TABLE ?";

  //CRUD
  private static final String INSERT = "INSERT INTO ? VALUES( ? )";
  private static final String SELECT = "SELECT * FROM ? ";
  private static final String UPDATE = "UPDATE TABLE ? SET ? ";
  private static final String DELETE = "DELETE FROM ? ";

  //FILTERS
  private static final String FILTER = "WHERE ?";

  //MOCK
  private static PreparedStatement executeQuery(String queryType, String... data) throws SQLException {
    Connection con = ConnectionManager.getConnection();

    String sql = buildQueryString(queryType, data);
    System.out.println(sql);
    PreparedStatement stm = con.prepareStatement(sql);

    stm.execute();
    return stm;
  }

  private static String buildQueryString(String queryType, String... params) {
    StringBuilder sql = new StringBuilder(queryType);
    for (String param : params) {
      sql.replace(sql.indexOf("?"), sql.indexOf("?") + 1, param);
    }
    return sql.toString();
  }

  public static void createTable(Object bean) throws SQLException {
    for(String def : SQLAssistant.getCreateDefinitions(bean))
      executeQuery(CREATE_TABLE, def);
  }

  public static ResultSet select(Object bean, String filter) throws SQLException {
    //TODO haz esto
    return executeQuery(SELECT + FILTER, SQLAssistant.getTables(bean).get(0).getName());
  }

  public static ResultSet selectAll(SQLAssistant table) throws SQLException {
  }

  public static void insert(SQLAssistant table, String values) throws SQLException {
  }

  public static void update(SQLAssistant table, String update, String filter) throws SQLException {
  }

  public static void delete(SQLAssistant table, String filter) throws SQLException {
  }

}
