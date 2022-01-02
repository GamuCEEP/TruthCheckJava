package domain.Utils;

import domain.Objects.Zone;
import domain.Resource;
import java.util.List;

public class GameMap extends Resource {

    private List<Zone> zones;

    public GameMap(int id, String name, String description, List<Zone> zones) {
        super(id, name, description);
        this.zones = zones;
    }

    public List<Zone> getZones() {
        return zones;
    }
    
    

}
