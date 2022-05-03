package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long id = Long.parseLong(request.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        User user = userDAO.readUser(id);
        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");
        User oldUser = (User) session.getAttribute("user");
        if (newUsername.equals("") || newEmail.equals("") || newPassword.equals("")) {
            request.setAttribute("oldID", oldUser.getId());
            getServletContext().getRequestDispatcher("/users/incorrectDataWhileEditing.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            User newUser = new User();
            newUser.setUserName(newUsername);
            newUser.setEmail(newEmail);
            newUser.setPassword(newPassword);
            if (oldUser != null) {
                userDAO.editUser(oldUser, newUser);
            }
            response.sendRedirect("/user/list");
        }
    }
}
