package domain.Utils;

import domain.Interactions.Event;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import jdk.internal.access.JavaAWTAccess;


public class Timeline {
    
    private List<Hashtable<Integer,Timestep>> timeline;
    private int currentStep = 0;

    public Timeline() {
        timeline = new ArrayList<>();
    }
    
    public void addTimestep(int index, Timestep step){
        int timelineSize = timeline.size();
        
        if(index >= timelineSize) index = timelineSize-1;
        if(index < 0) index = 0;
        
        timeline.get(index).put(index, step);
    }
    
    public List<Event> nextStep(){
        List<Timestep> posibleEvents = timeline.get(currentStep++);
        
        List<Timestep> selectedEvent = new ArrayList<>();
        
    }
    
    

    public class Timestep{
        
        private int priority;
        private double probability;
        private Event event;

        public Timestep(int priority, double probability, Event event) {
            this.priority = priority;
            this.probability = probability;
            this.event = event;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        public Event getEvent() {
            return event;
        }
    }   
    
}
