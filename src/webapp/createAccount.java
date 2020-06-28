package webapp;

import dataLayer.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "createAccount")
public class createAccount extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UserDAO userDAO = new UserDAO();

    if (userDAO.createAccount(username, password)) {
      request.setAttribute("username", username);
      request.setAttribute("password", password);
      request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    } else {
      request.setAttribute("errorMessage", "That username is already in use, "
          + "please pick something else.");
      request.getRequestDispatcher("/createAccount.jsp").forward(request, response);
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
