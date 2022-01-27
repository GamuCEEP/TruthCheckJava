package domain.beans.Utils;

import domain.beans.Interactions.Event;
import java.util.Map;



public class Timeline {
    
    private Map<Event, Integer> events;

    public Timeline() {}

    public Timeline(Map<Event, Integer> events) {
        this.events = events;
    }

    public Map<Event, Integer> getEvents() {
        return events;
    }

    public void setEvents(Map<Event, Integer> events) {
        this.events = events;
    }
    
    
}
