//package controller;
//
//import model.Author;
//import model.Category;
//import model.Post;
//import service.AuthorService;
//import service.CategoryService;
//import service.PostService;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(name = "HomePageServlet", urlPatterns = "/index")
//public class HomePageServlet extends HttpServlet {
//    PostService postService = new PostService();
//    CategoryService categoryService = new CategoryService();
//    AuthorService authorService = new AuthorService();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "view-post":
//                    viewPost(request, response);
//                    break;
//                case "editPost":
////                    showEditPost(request, response);
//                    break;
//                case "deletePost":
////                    deletePost(request, response);
//                    break;
//                default:
//                    homePage(request, response);
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }
//
//    private void viewPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Post existingPost = postService.findById(id);
//        List<Category> categoryList = categoryService.selectAll();
//        List<Author> authorList = authorService.selectAll();
//        request.setAttribute("authors", authorList);
//        request.setAttribute("categories", categoryList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view-post.jsp");
//        request.setAttribute("post", existingPost);
//        dispatcher.forward(request, response);
//    }
//
//    private void homePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        try {
//            List<Post> postList = postService.selectAll();
//            List<Post> postListLimit = postService.selectLimit(3);
//            Author author = authorService.findById(2);
//            List<Category> categoryList = categoryService.selectAll();
//            List<Post> postListCategoryLifestyle = categoryService.findAllPostByCategory(11);
//            request.setAttribute("categories", categoryList);
//            request.setAttribute("postsLifestyle", postListCategoryLifestyle);
//            request.setAttribute("author", author);
//            request.setAttribute("posts", postList);
//            request.setAttribute("postsLimit3", postListLimit);
//        } catch (SQLException e) {
//            response.sendRedirect("error-404.jsp");
//        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
//    }
//}
