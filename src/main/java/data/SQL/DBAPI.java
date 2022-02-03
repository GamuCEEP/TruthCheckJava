package data.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAPI {

  //DB MANAGEMENT
  private static final String CREATE_TABLE = "CREATE TABLE ? ( ? )";

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

  public static void createTable(Table table) throws SQLException {
    String createDefinition = formatListValues(table.getFields().toArray(
            new String[0]));
    executeQuery(CREATE_TABLE, table.getName(), createDefinition);
  }

  public static ResultSet select(Table table, String filter) throws SQLException {
    return executeQuery(SELECT + FILTER, table.getName(), filter).getResultSet();
  }

  public static ResultSet selectAll(Table table) throws SQLException {
    return executeQuery(SELECT, table.getName()).getResultSet();
  }

  public static void insert(Table table, String values) throws SQLException {
    executeQuery(INSERT, table.getName(), values);
  }

  public static void update(Table table, String update, String filter) throws SQLException {
    executeQuery(UPDATE + FILTER, table.getName(), update, filter);
  }

  public static void delete(Table table, String filter) throws SQLException {
    executeQuery(DELETE + FILTER, table.getName(), filter);
  }

  public static String formatListValues(String... values) {

    StringBuilder result = new StringBuilder();

    for (String value : values) {
      if (result.length() != 0) {
        result.append(',');
      }
      result.append(value);
    }
    return result.toString();
  }

  public static String formatFilter(String field, String... values) {
    StringBuilder sb = new StringBuilder();

    sb.append(field).append(" in (");
    sb.append(formatListValues(values));
    sb.append(")");

    return sb.toString();
  }

}
