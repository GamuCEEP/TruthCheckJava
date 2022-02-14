package logic.RestAPI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 * Returns all the requested resources as a JSON
 */
@WebServlet(name = "get", urlPatterns = {"/get"})
public class get extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try (PrintWriter out = response.getWriter()) {
      JSONObject requestedObjects = new JSONObject();

      request.getParameterMap().forEach((resourceRequest, ids) -> {
        if (!ResourceType.has(resourceRequest)) {
          requestedObjects.accumulate("IncorrectRequests", resourceRequest);
          return;
        }
        requestedObjects.put(resourceRequest + 's', serveResources(resourceRequest, ids));
      });
      
      out.print(requestedObjects);
    }
  }

  private String serveResourceNotFound() {
    return "ResourceNotFound";
  }

  private JSONObject serveResources(String resourceType, String... ids) {
    JSONObject response = new JSONObject();
    for (String id : ids) {
      int parsedId = 0;
      try {
        parsedId = Integer.parseInt(id);
      } catch (NumberFormatException e) {
        
      }
    }
    return response;
  }
}
