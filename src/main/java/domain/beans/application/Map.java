package domain.beans.application;

import java.util.ArrayList;
import java.util.List;

public class Map extends Resource {

  private List<Zone> zones;

  public Map() {
    zones = new ArrayList<>();
  }

  public Map(int id, String name, String description) {
    super(id, name, description);
    this.zones = new ArrayList<>();
  }

  public Map(int id, String name, String description, List<Zone> zones) {
    super(id, name, description);
    this.zones = zones;
  }

  public List<Zone> getZones() {
    return zones;
  }

  public void setZones(List<Zone> zones) {
    this.zones = zones;
  }

}
