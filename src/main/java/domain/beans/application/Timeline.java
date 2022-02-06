package domain.beans.application;

import Annotations.TableField;
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

  @TableField(Type = "INT", IsInvertedForeignKey = true, ForeignKey = "event(id)")
  public List<Event> getTimeline() {
    return timeline;
  }

  @TableField(Type = "INT", IsAutoIncremental = true, IsPrimaryKey = true)
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
