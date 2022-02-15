package logic.RestAPI;

import java.util.Map;
import domain.application.Actor;
import domain.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.application.ActorService;
import service.user.UserService;

/**
 *
 * @author GamuD
 */
@WebServlet(name = "actor", urlPatterns = {"/actor"})
public class actor extends HttpServlet {

  @Inject
  UserService userService;

  @Inject
  ActorService actorService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Object userName = req.getSession().getAttribute("userName");

    if (userName == null) {
      req.getRequestDispatcher("/pages/welcome.jsp").include(req, resp);
      return;
    }

    User loggedUser = userService.find(userName.toString());

    String name = req.getParameter("name");
    String description = req.getParameter("description");

    Map<String, String> stats = new HashMap<>();

    String[] mapKeys = req.getParameterValues("mapkey");
    if (mapKeys != null) {
      for (String key : mapKeys) {
        String val = req.getParameter(key);
        stats.put(key, val);
      }
    }

    List<User> author = new ArrayList<>();
    author.add(loggedUser);

    Actor actor = new Actor();
    actor.setName(name);
    actor.setDescription(description);
    actor.setStats(stats);
    actor.setAuthor(author);

    actorService.persist(actor);

    req.setAttribute("ok", true);
    req.setAttribute("resourceType", ResourceType.actor);
    req.getRequestDispatcher("/workspace").forward(req, resp);
  }
}
