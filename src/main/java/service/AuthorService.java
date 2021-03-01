package service;

import dao.AuthorDAO;
import model.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorService implements IBaseService<Author> {
    AuthorDAO authorDAO = new AuthorDAO();
    @Override
    public List<Author> selectAll() throws SQLException {
        return authorDAO.selectAll();
    }

    @Override
    public void insert(Author author) throws SQLException {
        authorDAO.insert(author);
    }

    @Override
    public Author findById(int id) throws SQLException {
        return authorDAO.findById(id);
    }

    @Override
    public boolean update(Author author) throws SQLException {
        return authorDAO.update(author);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return authorDAO.delete(id);
    }

    @Override
    public List<Author> search(String keyWord) throws SQLException {
        return authorDAO.search(keyWord);
    }
}
