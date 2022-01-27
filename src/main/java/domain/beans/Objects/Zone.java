
package domain.beans.Objects;

import domain.beans.Resource;
import domain.beans.Utils.Timeline;

public class Zone extends Resource{
    
    private Timeline timeline;
    
    public Zone(){}
    
    public Zone(int id, String name, String description, Timeline timeline) {
        super(id, name, description);
        this.timeline = timeline;
    }
    public Zone(int id, String name, String description) {
        super(id, name, description);
        this.timeline = new Timeline();
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
    
}
