package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    long id = Long.parseLong(request.getParameter("id"));
    UserDAO userDAO = new UserDAO();
    userDAO.deleteUser(id);
    response.sendRedirect("/user/list");
    }
}
