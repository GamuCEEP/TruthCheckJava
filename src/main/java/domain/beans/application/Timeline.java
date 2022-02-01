package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

  private List<List<Event>> timeline;

  public Timeline() {
    timeline = new ArrayList<>();
  }

  public List<List<Event>> getTimeline() {
    return timeline;
  }

  public void setTimeline(List<List<Event>> timeline) {
    this.timeline = timeline;
  }

}
