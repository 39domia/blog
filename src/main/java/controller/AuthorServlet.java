package controller;

import model.Author;
import model.Category;
import service.AuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AuthorServlet", urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {
    AuthorService authorService = new AuthorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createAuthor":
                    insertAuthor(request, response);
                    break;
                case "editAuthor":
                    editAuthor(request, response);
                    break;
                case "searchAuthor":
                    searchAuthor(request, response);
                    break;
                default:
                    listAuthor(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void editAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String authorName = request.getParameter("authorName");
        String authorDes = request.getParameter("authorDes");
        Author author = new Author(id, authorName, authorDes);
        authorService.update(author);
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/edit-author.jsp");
        dispatcher.forward(request, response);
    }

    private void insertAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String authorName = request.getParameter("authorName");
        String authorDes = request.getParameter("authorDes");
        Author author = new Author( authorName, authorDes);
        authorService.insert(author);
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/create-author.jsp");
        dispatcher.forward(request, response);
    }

    private void listAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Author> authorList = authorService.selectAll();
            request.setAttribute("authors", authorList);
        } catch (SQLException e) {
            response.sendRedirect("error-404.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/list-author.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createAuthor":
                    showCreateAuthor(request, response);
                    break;
                case "editAuthor":
                    showEditAuthor(request, response);
                    break;
                case "deleteAuthor":
                    deleteAuthor(request, response);
                    break;
                default:
                    listAuthor(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        List<Author> authorList = authorService.search(keyWord);
        System.out.println(authorList);
        request.setAttribute("authors", authorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/list-author.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/create-author.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Author existingAuthor = authorService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/edit-author.jsp");
        request.setAttribute("author", existingAuthor);
        dispatcher.forward(request, response);
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorService.delete(id);
        List<Author> authorList = authorService.selectAll();
        request.setAttribute("authors", authorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("author/list-author.jsp");
        dispatcher.forward(request, response);
    }
}
