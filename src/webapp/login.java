package webapp;

import dataLayer.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login")
public class login extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    UserDAO userDAO = new UserDAO();

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (userDAO.isValid(username, password)) {
      request.setAttribute("username", request.getParameter("username"));
      request.setAttribute("password", request.getParameter("password"));

      request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    } else {
      request.setAttribute("errorMessage", "Invalid username and/or password. Please try again");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();

    out.println("username: " + request.getParameter("username"));
    out.println("password: " + request.getParameter("password"));
  }
}
