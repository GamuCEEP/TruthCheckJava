package presentation.facades;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import logic.RestAPI.ResourceType;
import domain.application.Resource;
import java.util.ArrayList;
import org.json.JSONObject;
import service.application.IResourceService;
import service.application.ResourceServiceAgregator;

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

    List<Resource> resources = new ArrayList<>();

    List<? extends Resource> foundResources = new ResourceServiceAgregator().findAll();

    req.setAttribute("resources", new JSONObject(resources));

    req.setAttribute("ResourceTypes", ResourceType.values());
    req.getRequestDispatcher("/pages/gallery.jsp").forward(req, resp);
  }
}
