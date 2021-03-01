package service;

import dao.CategoryDAO;
import model.Category;
import model.Post;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements IBaseService<Category> {
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public List<Category> selectAll() throws SQLException {
        return categoryDAO.selectAll();
    }

    @Override
    public void insert(Category category) throws SQLException {
        categoryDAO.insert(category);
    }

    @Override
    public Category findById(int id) throws SQLException {
        return categoryDAO.findById(id);
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return categoryDAO.delete(id);
    }

    @Override
    public List<Category> search(String keyWord) throws SQLException {
        return categoryDAO.search(keyWord);
    }

    public List<Post> findAllPostByCategory(int idCategoryFind) throws SQLException {
        return categoryDAO.findAllPostByCategory(idCategoryFind);
    }
}
