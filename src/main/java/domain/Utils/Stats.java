package domain.Utils;

import java.util.HashMap;

public class Stats {
    
    private final HashMap<String, Value> stats;

    public Stats() {
        this.stats = new HashMap<>();
    }

    public HashMap<String, Value> getStats() {
        return stats;
    }
    
    public Value getStat(String key){
        return stats.get(key);
    }
    
}
