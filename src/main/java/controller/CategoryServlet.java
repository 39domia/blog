package controller;

import model.Category;
import service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createCategory":
                    insertCategory(request, response);
                    break;
                case "editCategory":
                    editCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id, name);
        categoryService.update(category);
        request.setAttribute("mess", "Edit success");
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/edit-category.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        Category newCategory = new Category(name);
        categoryService.insert(newCategory);
        request.setAttribute("mess", "Add success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/create-category.jsp");
        dispatcher.forward(request, response);
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
                case "createCategory":
                    showCreateCategory(request, response);
                    break;
                case "editCategory":
                    showEditCategory(request, response);
                    break;
                case "deleteCategory":
                    deleteCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        List<Category> categoryList = categoryService.selectAll();
        request.setAttribute("categories", categoryList);
        request.setAttribute("mess", "Delete success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/list-category.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/edit-category.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);
    }

    private void showCreateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/create-category.jsp");
        dispatcher.forward(request, response);
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Category> categoryList = categoryService.selectAll();
            request.setAttribute("categories", categoryList);
        } catch (SQLException e) {
            response.sendRedirect("error-404.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/list-category.jsp");
        dispatcher.forward(request, response);
    }
}
