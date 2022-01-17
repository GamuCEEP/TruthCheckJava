
package domain.Objects;

import domain.Resource;
<<<<<<< Updated upstream
import domain.Utils.Timeline;

public class Zone extends Resource{
    
    private Timeline timeline;
    public Zone(int id, String name, String description, Timeline timeline) {
        super(id, name, description);
        this.timeline = timeline;
    }
    public Zone(int id, String name, String description) {
        super(id, name, description);
        this.timeline = new Timeline();
    }
=======

public class Zone extends Resource{
    
    
>>>>>>> Stashed changes
    
}
