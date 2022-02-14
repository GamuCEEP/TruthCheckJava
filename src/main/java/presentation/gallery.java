package presentation;

import domain.application.*;
import service.application.*;
import java.io.IOException;
import logic.RestAPI.ResourceType;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;

@WebServlet(name = "gallery", urlPatterns = {"/gallery"})
public class gallery extends HttpServlet {

  @Inject
  ActorService actorService;
  @Inject
  EffectService effectService;
  @Inject
  EventService eventService;
  @Inject
  InteractionService interactionService;
  @Inject
  ItemService itemService;
  @Inject
  MapService mapService;
  @Inject
  RelationService relationService;
  @Inject
  StageService stageService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String filter = req.getParameter("filter") != null ? req.getParameter("filter") : "";

    List<Object> resources = new ArrayList<>();

    List<Actor> actorLibrary;
    List<Effect> effectLibrary;
    List<Event> eventLibrary;
    List<Interaction> interactionLibrary;
    List<Item> itemLibrary;
    List<Map> mapLibrary;
    List<Relation> relationLibrary;
    List<Stage> stageLibrary;

    actorLibrary = actorService.findText(filter);
    effectLibrary = effectService.findText(filter);
    eventLibrary = eventService.findText(filter);
    interactionLibrary = interactionService.findText(filter);
    itemLibrary = itemService.findText(filter);
    mapLibrary = mapService.findText(filter);
    relationLibrary = relationService.findText(filter);
    stageLibrary = stageService.findText(filter);

    resources.addAll(actorLibrary);
    resources.addAll(effectLibrary);
    resources.addAll(eventLibrary);
    resources.addAll(interactionLibrary);
    resources.addAll(itemLibrary);
    resources.addAll(mapLibrary);
    resources.addAll(relationLibrary);
    resources.addAll(stageLibrary);
    resources.addAll(actorLibrary);

    req.setAttribute("resources", new JSONObject(resources));

    req.setAttribute("ResourceTypes", ResourceType.values());
    req.getRequestDispatcher("/pages/gallery.jsp").forward(req, resp);
  }
}
