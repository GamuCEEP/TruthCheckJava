package logic.RestAPI;

public enum ResourceType {
  // Objects
  actor("Actores"),
  item("Items"),
  stage("Escenarios"),
  // Object collections
  map("Mapas"),
  // Base interaction
  effect("Effectos"),
  // Interactions
  interaction("Interacciones"),
  relation("Relaciones"),
  event("Eventos"),
  // Playables
  game("Partidas");

  private String webText;

  public String getWebText() {
    return webText;
  }

  public void setWebText(String webText) {
    this.webText = webText;
  }

  private ResourceType() {
  }

  private ResourceType(String webText) {
    this.webText = webText;
  }

  public static boolean has(String resourceType) {
    for (ResourceType type : ResourceType.values()) {
      if (type.toString().equals(resourceType)) {
        return true;
      }
    }
    return false;
  }

}
