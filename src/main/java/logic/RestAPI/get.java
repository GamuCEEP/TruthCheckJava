package logic.RestAPI;

import domain.beans.application.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exceptions.ResourceNotFoundException;
import org.json.JSONObject;


/**
 * Returns all the requested resources as a JSON 
 */
@WebServlet(name = "Rest", urlPatterns = {"/get"})
public class get extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try (PrintWriter out = response.getWriter()) {
      JSONObject requestedObjects = new JSONObject();

      request.getParameterMap().forEach((resourceType, ids) -> {
        if (!ResourceType.has(resourceType)) {
          serveIncorrectRequest(requestedObjects, resourceType);
          return;
        }
        requestedObjects.put(resourceType + 's', serveResources(resourceType, ids));
      });
      response.setHeader("Content-Type", "application/json");
      out.print(requestedObjects);
    }
  }

  private void serveIncorrectRequest(JSONObject response, String badRequest) {
    response.accumulate("IncorrectRequests", badRequest);
  }

  private String serveResourceNotFound() {
    return "ResourceNotFound";
  }

  private JSONObject serveResources(String resourceType, String... ids) {
    JSONObject response = new JSONObject();
    for (String id : ids) {
//      try {
//        //WARNING getResource is a mock implementation
//        Resource resource = dataAPI.getResource(resourceType, id);
//        JSONObject resourceJSON = new JSONObject(resource);
//
//        response.put(id, resourceJSON);
//      } catch (ResourceNotFoundException e) {
//        response.put(id, serveResourceNotFound());
//      }
    }
    return response;
  }
}
