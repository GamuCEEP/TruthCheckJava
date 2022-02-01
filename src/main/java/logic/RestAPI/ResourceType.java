

package logic.RestAPI;


public enum ResourceType {
    // Objects
    actor,
    item,
    zone,
    // Object collections
    map,
    // Base interaction
    effect,
    // Interactions
    interaction,
    relation,
    event,
    // Playables
    game;
    
    public static boolean has(String resourceType){
        for(ResourceType type : ResourceType.values())
            if(type.toString().equals(resourceType))
                return true;
        return false;
    }
    
}
