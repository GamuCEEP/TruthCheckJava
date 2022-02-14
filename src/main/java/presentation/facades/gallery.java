package presentation.facades;

import domain.application.*;
import service.application.*;
import java.io.IOException;
import logic.RestAPI.ResourceType;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;

@WebServlet(name = "gallery", urlPatterns = {"/gallery"})
public class gallery extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Object> resources = new ArrayList<>();
    
    List<Actor> actorLibrary = new ActorService().findText("");
    List<Effect> effectLibrary = new EffectService().findText("");
    List<Event> eventLibrary = new EventService().findText("");
    List<Interaction> interactionLibrary = new InteractionService().findText("");
    List<Item> itemLibrary = new ItemService().findText("");
    List<Map> mapLibrary = new MapService().findText("");
    List<Relation> relationLibrary = new RelationService().findText("");
    List<Stage> stageLibrary = new StageService().findText("");
    
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
