package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

  private int id;
  private List<Event> timeline;

  public Timeline() {
    timeline = new ArrayList<>();
  }

  public Timeline(int id, List<Event> timeline) {
    this.id = id;
    this.timeline = timeline;
  }

  public List<Event> getTimeline() {
    return timeline;
  }

  public int getId() {
    return id;
  }

  public void setTimeline(List<Event> timeline) {
    this.timeline = timeline;
  }

  public void setId(int id) {
    this.id = id;
  }

}
