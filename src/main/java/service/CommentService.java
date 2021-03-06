package service;

import dao.CommentDAO;
import model.Comment;

import java.sql.SQLException;
import java.util.List;

public class CommentService implements IBaseService<Comment> {
    CommentDAO commentDAO = new CommentDAO();
    @Override
    public List<Comment> selectAll() throws SQLException {
        return commentDAO.selectAll();
    }

    @Override
    public void insert(Comment comment) throws SQLException {
        commentDAO.insert(comment);
    }

    @Override
    public Comment findById(int id) throws SQLException {
        return commentDAO.findById(id);
    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        return commentDAO.update(comment);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return commentDAO.delete(id);
    }

    @Override
    public List<Comment> search(String keyWord) throws SQLException {
        return commentDAO.search(keyWord);
    }
}
