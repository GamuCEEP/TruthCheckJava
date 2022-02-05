package data.DAOs.application;

import data.SQL.DBAPI;
import data.SQL.SQLAssistant;
import data.SQL.Table;
import domain.beans.application.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {

  private static Table actorTable;
  private static Table statsTable;

  public ActorDAO() {
        //TODO continuar esto jiji
  }

  //Select
  public List<Actor> select(String field, String... values) throws SQLException {
    return null;
  }

  //Insert
  public void insert(Actor... actors) throws SQLException {

  }

  //Update
  public void update(Actor... actor) throws SQLException {

  }

  //Delete
  public void delete(String... ids) throws SQLException {

  }

}
