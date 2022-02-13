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
@WebServlet(name = "home", urlPatterns = {"/home"})
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

    Object userNameAttr = req.getSession().getAttribute("userName");

    if (userNameAttr == null) {
      req.getRequestDispatcher("/pages/welcome.jsp").include(req, resp);
      return;
    }

    String userName = userNameAttr.toString();

    req.setAttribute("userName", userName);
    req.getRequestDispatcher("/pages/home.jsp").include(req, resp);
  }
}
