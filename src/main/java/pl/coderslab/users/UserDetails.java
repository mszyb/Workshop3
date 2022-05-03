package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDetails", value = "/user/show")
public class UserDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        UserDAO userDAO = new UserDAO();
        user = userDAO.readUser(id);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/userDetails.jsp").forward(request, response);
    }
}
