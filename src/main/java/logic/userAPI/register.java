package logic.userAPI;

import data.DAOs.user.UserDAO;
import domain.beans.user.User;
import java.io.PrintWriter;
import java.io.IOException;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.user.UserService;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

  @Inject
  UserService userService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String userName = req.getParameter("user");
    String password = req.getParameter("password");

    User user = userService.find(userName);

    if (user != null) {
      resp.setHeader("registerError", "UserAlreadyExists");
      req.getRequestDispatcher("welcome").forward(req, resp);
      return;
    }

    user = new User(userName, password);

    userService.persist(user);

    req.getSession().setAttribute("userName", userName);
    resp.sendRedirect("home");

  }

}
