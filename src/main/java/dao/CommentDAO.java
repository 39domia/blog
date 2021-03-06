package dao;

import model.Comment;

import java.sql.SQLException;
import java.util.List;

public class CommentDAO extends DBDAO implements IBaseDAO<Comment> {
    @Override
    public List<Comment> selectAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(Comment comment) throws SQLException {

    }

    @Override
    public Comment findById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Comment> search(String keyword) throws SQLException {
        return null;
    }
}
