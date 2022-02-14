package logic.userAPI;

import data.DAOs.user.UserDAO;
import domain.beans.user.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import org.json.*;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*TODO implement login 
        -Client sends form data with username and hashed password
        -user is seached by name and stored password(hashed) is compared to the given password(hashed)
        -If theres a match session variable user is set to username, an empty response is sent
        -If not, a JSON with tried user is sent
     */

    String userName = req.getParameter("user");
    String password = req.getParameter("password");

    UserDAO uDAO = new UserDAO();

    User user = uDAO.find(userName);

    if (user == null) {
      resp.setHeader("loginError", "UserNotFound");
      req.getRequestDispatcher("welcome").forward(req, resp);
      return;
    }

    if (!user.getPassword().equals(password)) {
      resp.setHeader("loginError", "IncorrectPassword");
      req.getRequestDispatcher("welcome").forward(req, resp);
      return;
    }

    req.getSession().setAttribute("userName", userName);
    resp.addCookie(new Cookie("userName", userName));
    req.getRequestDispatcher("home").forward(req, resp);
  }
}
