
package presentation.facades;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author GamuD
 */
@WebServlet(name="home", urlPatterns={"/home"})
public class home extends HttpServlet {
   
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }
  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/pages/home.jsp").include(req, resp);
    
    Object userNameAttr = req.getSession().getAttribute("userName");
    String userName = (userNameAttr != null ? userNameAttr.toString() : "");
    
    req.setAttribute("message",new JSONObject("userName", userName));
    req.getRequestDispatcher("/talk/talk.jsp").include(req, resp);
   
  }
}
