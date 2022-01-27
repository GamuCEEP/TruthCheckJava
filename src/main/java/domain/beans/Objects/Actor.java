package domain.beans.Objects;

import domain.beans.Resource;
import domain.beans.Utils.Stats;

public class Actor extends Resource {

    private Stats stats;
    
    public Actor(){}

    public Actor(int id, String name, String description, Stats stats) {
        super(id, name, description);
        this.stats = stats;
    }
    public Actor(int id, String name, String description) {
        super(id, name, description);
        this.stats = new Stats();
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
    
}
