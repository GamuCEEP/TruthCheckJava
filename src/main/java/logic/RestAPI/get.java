package logic.RestAPI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.function.Consumer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.beans.Objects.*;
import domain.beans.Interactions.*;
import exceptions.ResourceNotFoundException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "Rest", urlPatterns = {"/rest"})
public class get extends HttpServlet {

    private Map<String, Consumer<String>> restHandler;

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
        
        request.getParameterMap().forEach((p, v) -> {
            if (!restHandler.containsKey(p)) {
                requestedObjects.put("", serveIncorrectRequest(p));
                return;
            }
            restHandler.get(p).accept(v[0]);
        });
        out.close();
    }

    private JSONObject serveIncorrectRequest(String p) {
        // TODO gestiona la respuesta de una request incorrecta
        return null;
    }

    private JSON serveResourceNotFound() {
        error.put("error", value);
        return null;
    }

    /// TODO añaden al response los recursos pedidos
    private JSONObject serveActor(String... ids) {
        JSONObject actors = new JSONObject();
        for (String id : ids) {
            try {
                // TODO get the resource
            } catch (ResourceNotFoundException e) {
                actors.put(id, serveResourceNotFound());
            }
        }

        return null;
    }

    private JSONObject serveItem(String... ids) {
        return null;
    }

    private JSONObject serveZone(String... ids) {
        return null;
    }

    private JSONObject serveEffect(String... ids) {
        return null;
    }

    private JSONObject serveEvent(String... ids) {
        return null;
    }

    private JSONObject serveInteraction(String... ids) {
        return null;
    }

    private JSONObject serveRelation(String... ids) {
        return null;
    }
}
