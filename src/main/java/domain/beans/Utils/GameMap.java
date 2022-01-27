package domain.beans.Utils;

import domain.beans.Objects.Zone;
import domain.beans.Resource;
import java.util.ArrayList;
import java.util.List;

public class GameMap extends Resource {

    private List<Zone> zones;
    
    public GameMap(){}

    public GameMap(int id, String name, String description, List<Zone> zones) {
        super(id, name, description);
        this.zones = zones;
    }
    public GameMap(int id, String name, String description) {
        super(id, name, description);
        this.zones = new ArrayList<>();
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
    
}
