package data.DAOs.application;

import logic.RestAPI.ResourceType;

public class DAOManager {

  public static IResourceDAO getDAO(ResourceType type) {
    switch (type) {
      case actor:
        return new ActorDAO();
      case effect:
        return new EffectDAO();
      case event:
        return new EventDAO();
      case game:
        return new GameDAO();
      case interaction:
        return new InteractionDAO();
      case item:
        return new ItemDAO();
      case map:
        return new MapDAO();
      case relation:
        return new RelationDAO();
      case stage:
        return new StageDAO();
      default:
        //Añadir los ResourceType
        assert false;
        return null;
    }
  }
}
