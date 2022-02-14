package service.application;

import java.util.List;
import javax.inject.Inject;
import domain.beans.application.Resource;
import java.util.ArrayList;

public class ResourceServiceAgregator {

  //@Inject
  //GameService game;
  ActorService actor;
  EffectService effect;
  EventService event;
  InteractionService interaction;
  ItemService item;
  MapService map;
  RelationService relation;
  StageService stage;

  public ResourceServiceAgregator() {
    this.actor = new ActorService();
    this.effect = new EffectService();
    this.event = new EventService();
    this.interaction = new InteractionService();
    this.item = new ItemService();
    this.map = new MapService();
    this.relation = new RelationService();
    this.stage = new StageService();
  }

  public List<Resource> findAll() {
    List<Resource> resources = new ArrayList<>();

    resources.addAll(actor.findAll());
    resources.addAll(effect.findAll());
    resources.addAll(event.findAll());
    resources.addAll(interaction.findAll());
    resources.addAll(item.findAll());
    resources.addAll(map.findAll());
    resources.addAll(relation.findAll());
    resources.addAll(stage.findAll());

    return resources;
  }

  public List<Resource> findText(String text) {
    List<Resource> resources = new ArrayList<>();

    resources.addAll(actor.findText(text));
    resources.addAll(effect.findText(text));
    resources.addAll(event.findText(text));
    resources.addAll(interaction.findText(text));
    resources.addAll(item.findText(text));
    resources.addAll(map.findText(text));
    resources.addAll(relation.findText(text));
    resources.addAll(stage.findText(text));

    return resources;
  }
}
