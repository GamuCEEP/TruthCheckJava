package domain;


public abstract class Resource {
    
    private final int id;
    private String name;
    private String description;

    public Resource(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
