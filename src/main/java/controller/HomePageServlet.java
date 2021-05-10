package controller;
import model.Category;
import model.Post;
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

@WebServlet(name = "HomePageServlet", urlPatterns = "/index")
public class HomePageServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view-post":
                    viewPost(request, response);
                    break;
                case "view-category":
                    showCategory(request, response);
                    break;
                case "deletePost":
//                    deletePost(request, response);
                    break;
                default:
                    homePage(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Category> categoryList = categoryService.selectAll();
        int categoryId = Integer.parseInt(request.getParameter("category-id"));
        Category category = categoryService.findById(categoryId);
        List<Post> postList = postService.selectAllPostCategory(categoryId);
        request.setAttribute("categories", categoryList);
        request.setAttribute("category", category);
        request.setAttribute("posts", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category.jsp");
        dispatcher.forward(request, response);

    }

    private void viewPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post existingPost = postService.findById(id);
        List<Category> categoryList = categoryService.selectAll();
        List<User> userList = userService.selectAll();
        request.setAttribute("users", userList);
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/view-post.jsp");
        request.setAttribute("post", existingPost);
        dispatcher.forward(request, response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Post> postList = postService.selectAll();
            List<Post> postListLimit = postService.selectLimit(3);
            User user = userService.findById(1);
            List<Category> categoryList = categoryService.selectAll();
            List<Post> postListCategoryLifestyle = categoryService.findAllPostByCategory(11);
            request.setAttribute("categories", categoryList);
            request.setAttribute("postsLifestyle", postListCategoryLifestyle);
            request.setAttribute("user", user);
            request.setAttribute("posts", postList);
            request.setAttribute("postsLimit3", postListLimit);
        } catch (SQLException e) {
            response.sendRedirect("error-404.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
        dispatcher.forward(request, response);
    }
}
