package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically populated with
   * all resources defined in the project.
   * If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(service.ActorFacadeREST.class);
    resources.add(service.EffectFacadeREST.class);
    resources.add(service.EventFacadeREST.class);
    resources.add(service.InteractionFacadeREST.class);
    resources.add(service.ItemFacadeREST.class);
    resources.add(service.MapFacadeREST.class);
    resources.add(service.StageFacadeREST.class);
    resources.add(service.StatsFacadeREST.class);
    resources.add(service.TriggerFacadeREST.class);
    resources.add(service.UserFacadeREST.class);
  }

}
