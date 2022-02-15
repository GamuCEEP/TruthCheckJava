
package logic.userAPI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }
  
  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("LOGOUT ya te vassss ");
    req.getSession().invalidate();
    resp.sendRedirect("pages/welcome.jsp");
  }
  
  
}
