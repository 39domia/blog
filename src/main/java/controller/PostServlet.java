package controller;

import model.Author;
import model.Category;
import model.Post;
import service.AuthorService;
import service.CategoryService;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PostServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    AuthorService authorService = new AuthorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        postService.delete(id);
        List<Post> postList = postService.selectAll();
        request.setAttribute("posts", postList);
        List<Category> categoryList = categoryService.selectAll();
        List<Author> authorList = authorService.selectAll();
        request.setAttribute("authors", authorList);
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post existingPost = postService.findById(id);
        List<Category> categoryList = categoryService.selectAll();
        List<Author> authorList = authorService.selectAll();
        request.setAttribute("authors", authorList);
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/edit-post.jsp");
        request.setAttribute("post", existingPost);
        dispatcher.forward(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String postTitle = request.getParameter("postTitle");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int idCategory = Integer.parseInt(request.getParameter("categorys"));
        int idAuthor = Integer.parseInt(request.getParameter("authors"));
        Category category = new Category(idCategory);
        Author author = new Author(idAuthor);
        Post newPost = new Post(id, postTitle, fullContent, shortContent, image, category, author);
        postService.update(newPost);
        List<Category> categoryList = categoryService.selectAll();
        List<Author> authorList = authorService.selectAll();
        List<Post> postList = postService.selectAll();
        request.setAttribute("authors", authorList);
        request.setAttribute("posts", postList);
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/edit-post.jsp");
        dispatcher.forward(request, response);
    }


    private void listPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Post> postList = postService.selectAll();
            request.setAttribute("posts", postList);
        } catch (SQLException e) {
            response.sendRedirect("error-404.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/list-post.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String postTitle = request.getParameter("postTitle");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int idCategory = Integer.parseInt(request.getParameter("categorys"));
        int idAuthor = Integer.parseInt(request.getParameter("authors"));
        Category newCategory = new Category(idCategory);
        Author newAuthor = new Author(idAuthor);
        Post newPost = new Post(postTitle, fullContent, shortContent, image, newCategory, newAuthor);
        postService.insert(newPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/create-post.jsp");
        dispatcher.forward(request, response);
    }


    private void showCreatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Category> categoryList = categoryService.selectAll();
        List<Author> authorList = authorService.selectAll();
        request.setAttribute("authors", authorList);
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/create-post.jsp");
        dispatcher.forward(request, response);
    }
}
