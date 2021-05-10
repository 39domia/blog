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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PostServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createPost":
                    insertPost(request, response);
                    break;
                case "editPost":
                    editPost(request, response);
                    break;
                default:
                    listPost(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createPost":
                    showCreatePost(request, response);
                    break;
                case "editPost":
                    showEditPost(request, response);
                    break;
                case "deletePost":
                    deletePost(request, response);
                    break;
                case "searchPost":
                    searchPost(request, response);
                    break;
                default:
                    listPost(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        List<Post> postList = postService.search(keyWord);
        request.setAttribute("posts", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        postService.delete(id);
        List<Post> postList = postService.selectAll();
        request.setAttribute("posts", postList);
        request.setAttribute("mess", "Delete success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post existingPost = postService.findById(id);
        List<Category> categoryList = categoryService.selectAll();
        List<User> userList = userService.selectAll();
        request.setAttribute("users", userList);
        request.setAttribute("categories", categoryList);
        request.setAttribute("post", existingPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/edit-post.jsp");
        dispatcher.forward(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session=request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String postTitle = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Category category = new Category(idCategory);
        int idUser;
        int role = (int) session.getAttribute("role");
        if ( role == 1){
            idUser = Integer.parseInt(request.getParameter("user"));
        }else {
            idUser = (Integer) session.getAttribute("idUser");
        }
        User user = new User(idUser);
        Post newPost = new Post(id, postTitle, fullContent, shortContent, image, category, user);
        postService.update(newPost);
        List<Category> categoryList = categoryService.selectAll();
        List<Post> postList = postService.selectAll();
        request.setAttribute("posts", postList);
        request.setAttribute("categories", categoryList);
        request.setAttribute("post", newPost);
        request.setAttribute("mess", "Edit success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/edit-post.jsp");
        dispatcher.forward(request, response);
    }


    private void listPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session =request.getSession();
        try {
            List<Post> userPostList=postService.selectAllPostUser((Integer) session.getAttribute("idUser"));
            request.setAttribute("postsUser",userPostList);
            List<Post> postList = postService.selectAll();
            request.setAttribute("posts", postList);
        } catch (SQLException e) {
            response.sendRedirect("error-404.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<String> errorList =  new ArrayList<>();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int categoryID = Integer.parseInt(request.getParameter("category"));
        if (title.isEmpty() || title.length() > 200){
            errorList.add("Title field is empty or too long");
        }
        if (shortContent.isEmpty()){
            errorList.add("Short content field is empty");
        }
        if (errorList.size() == 0){
            Category category = new Category(categoryID);
            int idUser;
            int role = (int) session.getAttribute("role");
            if (role == 1) {
                idUser = Integer.parseInt(request.getParameter("user"));
            } else {
                idUser = (Integer) session.getAttribute("idUser");
            }
            User user = new User(idUser);
            Post newPost = new Post(title, fullContent, shortContent, image, category, user);
            postService.insert(newPost);
            request.setAttribute("mess", "Add success");
            List<Category> categoryList = categoryService.selectAll();
            List<User> userList = userService.selectAll();
            request.setAttribute("categories", categoryList);
            request.setAttribute("users", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/create-post.jsp");
            dispatcher.forward(request, response);
        }
        else {
            request.setAttribute("errors", errorList);
            List<Category> categoryList = categoryService.selectAll();
            List<User> userList = userService.selectAll();
            request.setAttribute("categories", categoryList);
            request.setAttribute("users", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/create-post.jsp");
            dispatcher.forward(request, response);
        }

    }


    private void showCreatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Category> categoryList = categoryService.selectAll();
        List<User> userList = userService.selectAll();
        request.setAttribute("categories", categoryList);
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/post/create-post.jsp");
        dispatcher.forward(request, response);
    }
}
