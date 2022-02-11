
package logic.userAPI;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*TODO implement logout
      -Sets session variable user to null
      -Reloads the page
    */
    System.out.println("LOGOUT ya te vassss ");
    req.getRequestDispatcher("TruthCheckJava/pages/welcome.html").forward(req, resp);
  }
  
}
