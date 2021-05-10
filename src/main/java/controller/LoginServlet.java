package controller;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "login";
        }
        try {
            switch (action) {
                case "login":
                    doLogin(request, response);
                    break;
                case "register":
                    doRegister(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password-repeat");
        if (!password.equals(passwordRepeat)){
            session.invalidate();
            request.setAttribute("mess", "Password and password repeat do not match");
            showRegister(request, response);
            return;
        }
        User userRegister = new User(email, password, fullName);
        List<User> userList = userService.selectAll();
        for (User user : userList) {
            if (user.getEmail().equals(userRegister.getEmail())) {
                session.invalidate();
                request.setAttribute("mess", "Email is existed!");
                showRegister(request, response);
                return;
            }
        }
        userService.register(new User(email, password, fullName));
        request.setAttribute("mess", "Register Success!");
        showLoginForm(request, response);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.findByUserAndPassword(email, password);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("fullName", user.getFullName());
            session.setAttribute("role", user.getRole());
            session.setAttribute("idUser", user.getId());
            response.sendRedirect("post");
        } else {
            session.invalidate();
            request.setAttribute("mess", "User or password is fail!Try again");
            showLoginForm(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "login";
        }
        switch (action) {
            case "login":
                showLoginForm(request, response);
                break;
            case "logout":
                doLogout(request, response);
                break;
            case "register":
                showRegister(request, response);
                break;
        }
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/register.jsp");
        dispatcher.forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }


    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        showLoginForm(request, response);
    }
}
