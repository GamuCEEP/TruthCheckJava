package data.DAOs.application;

import data.SQL.DBAPI;
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
    actorTable = new Table("actor")
    .addField("id", Table.FieldType.INT,true,true)
    .addField("name", Table.FieldType.VARCHAR)
    .addField("description", Table.FieldType.VARCHAR);
    
    statsTable = new Table("stats")
    .addField("actorId", Table.FieldType.INT, false, true, "actor(id)")
    .addField("stat", Table.FieldType.VARCHAR, false, true)
    .addField("value", Table.FieldType.VARCHAR);   
    
    
  }

  //Select
  public List<Actor> select(String field, String... values) throws SQLException {

    ResultSet result = DBAPI.select(actorTable, DBAPI.formatFilter(field, values));
    
    List<Actor> selectedActors = new ArrayList<>();
    
    while(result.next()){
      Actor actor = new Actor();
      actor.setId(result.getInt("id"));
      actor.setName(result.getString("name"));
      actor.setDescription(result.getString("description"));
      actor.setStats(result.getInt("id"));
    }
    
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
