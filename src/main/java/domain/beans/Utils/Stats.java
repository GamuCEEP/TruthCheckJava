package domain.beans.Utils;

import java.util.HashMap;
import java.util.Map;

public class Stats {

    private Map<String, String> stats;

    public Stats() {
        this.stats = new HashMap<>();
    }
    public Stats(Map<String, String> stats){
        this.stats = stats;
    }

    public Map<String, String> getStats() {
        return stats;
    }

    public void setStats(Map<String, String> stats) {
        this.stats = stats;
    }
    
}
