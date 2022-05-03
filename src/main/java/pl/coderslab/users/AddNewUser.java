package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNewUser", value = "/user/add")
public class AddNewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/addNewUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(username.equals("") || email.equals("") || password.equals("")){
            getServletContext().getRequestDispatcher("/users/incorrectData.jsp").forward(request, response);
        } else {
            User user = new User();
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);
            UserDAO userDAO = new UserDAO();
            user = userDAO.createNewUser(user);
            response.sendRedirect("/user/list");
        }
    }
}
