package logic.RestAPI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.beans.Objects.*;
import domain.beans.Interactions.*;
import exceptions.ResourceNotFoundException;
import java.util.HashMap;
import org.json.JSONObject;

@WebServlet(name = "Rest", urlPatterns = {"/rest"})
public class get extends HttpServlet {

  private Map<String, BiConsumer<JSONObject, String[]>> restHandler;

  public get() {
    restHandler = new HashMap<>();
    restHandler.put("effect", this::serveEffect);
    restHandler.put("event", this::serveEvent);
    restHandler.put("interaction", this::serveInteraction);
    restHandler.put("relation", this::serveRelation);
    restHandler.put("actor", this::serveActor);
    restHandler.put("item", this::serveItem);
    restHandler.put("zone", this::serveZone);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    JSONObject requestedObjects = new JSONObject();

    request.getParameterMap().forEach((resourceType, ids) -> {
      if (!restHandler.containsKey(resourceType)) {
        serveIncorrectRequest(requestedObjects, resourceType);
        return;
      }
      restHandler.get(resourceType).accept(requestedObjects, ids);
    });
    response.setHeader("Content-Type", "application/json");
    out.print(requestedObjects);
    out.close();
  }

  private void serveIncorrectRequest(JSONObject response, String badRequest) {
    response.accumulate("IncorrectRequests", badRequest);
  }

  private String serveResourceNotFound() {
    return "ResourceNotFound";
  }
  
  private void serveActor(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveItem(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveZone(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveEffect(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveEvent(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveInteraction(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }

  private void serveRelation(JSONObject response, String... ids) {
    if (!response.has("actors")) {
      response.put("actors", new JSONObject());
    }

    for (String id : ids) {
      try {
        // TODO get the resource
      } catch (ResourceNotFoundException e) {
        response.getJSONObject("actors").accumulate(id, serveResourceNotFound());
      }
    }
  }
}
