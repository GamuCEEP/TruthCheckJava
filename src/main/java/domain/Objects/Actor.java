package domain.Objects;

import domain.Resource;
import domain.Utils.Stats;

public class Actor extends Resource {

    private Stats stats;

    public Actor(int id, String name, String description, Stats stats) {
        super(id, name, description);
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }
    
    

}
