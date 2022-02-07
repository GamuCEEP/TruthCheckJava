package data.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAPI {

  //DB MANAGEMENT
  private static final String CREATE_TABLE = "CREATE TABLE ?";

  //CRUD
  private static final String INSERT = "INSERT INTO ? SET ?";
  private static final String SELECT = "SELECT * FROM ? ";
  private static final String UPDATE = "UPDATE ? SET ? ";
  private static final String DELETE = "DELETE FROM ? ";

  //FILTERS
  private static final String FILTER = "WHERE ?";

  //MOCK
  private static ResultSet executeQuery(String queryType, String... data) throws SQLException {
    Connection con = ConnectionManager.getConnection();

    String sql = buildQueryString(queryType, data);
    System.out.println(sql);
    PreparedStatement stm = con.prepareStatement(sql);

    stm.execute();
    return stm.getResultSet();
  }

  private static String buildQueryString(String queryType, String... params) {
    StringBuilder sql = new StringBuilder(queryType);
    for (String param : params) {
      sql.replace(sql.indexOf("?"), sql.indexOf("?") + 1, param);
    }
    return sql.toString();
  }

  public static void createTable(Object bean) throws SQLException {
    for (String def : SQLAssistant.getCreateDefinitions(bean)) {
      executeQuery(CREATE_TABLE, def);
    }
  }

  public static ResultSet select(Object bean, String filter) throws SQLException {
    return executeQuery(SELECT + FILTER, SQLAssistant.getTableName(bean));
  }

  public static ResultSet selectAll(Object bean) throws SQLException {
    return executeQuery(SELECT, SQLAssistant.getTableName(bean));
  }

  public static void insert(Object... beans) throws SQLException {
    for (Object bean : beans) {
      mock_executeQuery(INSERT, SQLAssistant.getTableName(bean),
              SQLAssistant.getInsertValue(bean));
    }
  }

  //MOCK METHOD
  private static String mock_executeQuery(String queryType, String... data) throws SQLException {

    System.out.println(buildQueryString(queryType, data));
    return null;
  }

  public static void update(Object... updatedBeans) throws SQLException {
    for (Object bean : updatedBeans) {
      executeQuery(UPDATE + FILTER, SQLAssistant.getTableName(bean),
              SQLAssistant.getInsertValue(bean), SQLAssistant.getFilter(bean));
    }
  }

  public static void delete(Object... beans) throws SQLException {
    for (Object bean : beans) {
      System.out.println(buildQueryString(DELETE + FILTER,
              SQLAssistant.getTableName(bean), SQLAssistant.getFilter(bean)));
    }
  }

}
