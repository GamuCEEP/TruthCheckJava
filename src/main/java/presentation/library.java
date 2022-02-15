package presentation;

import domain.application.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.RestAPI.ResourceType;
import service.user.UserService;
import domain.user.User;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author GamuD
 */
@WebServlet(name = "library", urlPatterns = {"/library"})
public class library extends HttpServlet {

  @Inject
  UserService userService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Object loggedUser = req.getSession().getAttribute("userName");

    if (loggedUser == null) {
      req.getRequestDispatcher("/pages/welcome.jsp").forward(req, resp);
      return;
    }

    String userName = loggedUser.toString();

    User user = userService.find(userName);

    List<Actor> actorLibrary = user.getActorLibrary();
    List<Effect> effectLibrary = user.getEffectLibrary();
    List<Event> eventLibrary = user.getEventLibrary();
    List<Interaction> interactionLibrary = user.getInteractionLibrary();
    List<Item> itemLibrary = user.getItemLibrary();
    List<Map> mapLibrary = user.getMapLibrary();
    List<Relation> relationLibrary = user.getRelationLibrary();
    List<Stage> stageLibrary = user.getStageLibrary();

    List<Resource> resources = new ArrayList<>();

    resources.addAll(actorLibrary);
    resources.addAll(effectLibrary);
    resources.addAll(eventLibrary);
    resources.addAll(interactionLibrary);
    resources.addAll(itemLibrary);
    resources.addAll(mapLibrary);
    resources.addAll(relationLibrary);
    resources.addAll(stageLibrary);
    resources.addAll(actorLibrary);

//    String filter = req.getParameter("filter") != null ? req.getParameter("filter") : "";
//
//    resources.removeIf((res) -> {
//      return false;
//    });

    req.setAttribute("resources", resources);

    req.setAttribute("ResourceTypes", ResourceType.values());
    req.getRequestDispatcher("/pages/gallery.jsp").forward(req, resp);
  }
}
