package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserList", value = "/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       UserDAO userDAO = new UserDAO();
       request.setAttribute("users", userDAO.findAllUsers());
    getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }


}
