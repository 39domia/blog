package controller;

import model.User;
import service.CategoryService;
import service.PostService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createUser":
                    insertUser(request, response);
                    break;
                case "editUser":
                    editUser(request, response);
                    break;
                default:
                    listUser(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String alias = request.getParameter("alias");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        String fullName = request.getParameter("fullName");
        int yob = Integer.parseInt(request.getParameter("yob"));
        String description = request.getParameter("description");
        String about = request.getParameter("about");
        String image = request.getParameter("image");
        User user = new User(email, alias, password, role, fullName, yob, description, about, image);
        userService.insert(user);
        request.setAttribute("mess", "Add success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/create-user.jsp");
        dispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String alias = request.getParameter("alias");
        int role = Integer.parseInt(request.getParameter("role"));
        String fullName = request.getParameter("fullName");
        int yob = Integer.parseInt(request.getParameter("yob"));
        String description = request.getParameter("description");
        String about = request.getParameter("about");
        String image = request.getParameter("image");
        User user = new User(id, email, alias, role, fullName, yob, description, about, image);
        userService.update(user);
        request.setAttribute("mess", "Edit success");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/edit-user.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createUser":
                    showCreateUser(request, response);
                    break;
                case "editUser":
                    showEditUser(request, response);
                    break;
                case "deleteUser":
                    deleteUser(request, response);
                    break;
                default:
                    listUser(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/create-user.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/edit-user.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        List<User> userList = userService.selectAll();
        request.setAttribute("users", userList);
        request.setAttribute("mess", "Delete success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/list-user.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> userList = userService.selectAll();
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/list-user.jsp");
        dispatcher.forward(request, response);
    }
}
