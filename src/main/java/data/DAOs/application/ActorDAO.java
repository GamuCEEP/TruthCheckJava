package data.DAOs.application;

import data.SQL.DBAPI;
import data.SQL.SQLAssistant;
import domain.beans.application.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {

  private static SQLAssistant actorTable;
  private static SQLAssistant statsTable;

  public ActorDAO() {
    actorTable = new SQLAssistant("actor")
    .addField("id", SQLAssistant.FieldType.INT,true,true)
    .addField("name", SQLAssistant.FieldType.VARCHAR)
    .addField("description", SQLAssistant.FieldType.VARCHAR);
    
    statsTable = new SQLAssistant("stats")
    .addField("actorId", SQLAssistant.FieldType.INT, false, true, "actor(id)")
    .addField("stat", SQLAssistant.FieldType.VARCHAR, false, true)
    .addField("value", SQLAssistant.FieldType.VARCHAR);   
    
    
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
      //actor.setStats(result.getInt("id"));
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
