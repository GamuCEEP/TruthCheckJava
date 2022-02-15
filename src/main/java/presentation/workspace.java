
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.RestAPI.ResourceType;

/**
 *
 * @author GamuD
 */
@WebServlet(name="workspace", urlPatterns={"/workspace"})
public class workspace extends HttpServlet {
   
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    defaultAction(req, resp);
  }
  private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    req.setAttribute("ResourceTypes", ResourceType.values());
    req.getRequestDispatcher("/pages/workspace.jsp").forward(req, resp);
  }
}
