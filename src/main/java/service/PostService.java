package service;

import dao.PostDAO;
import model.Post;

import java.sql.SQLException;
import java.util.List;

public class PostService implements IBaseService<Post>{
    PostDAO postDAO = new PostDAO();

    @Override
    public List<Post> selectAll() throws SQLException {
        return postDAO.selectAll();
    }

    @Override
    public void insert(Post post) throws SQLException {
        postDAO.insert(post);

    }

    @Override
    public Post findById(int id) throws SQLException {
        return postDAO.findById(id);
    }

    @Override
    public boolean update(Post post) throws SQLException {
        return postDAO.update(post);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return postDAO.delete(id);
    }

    @Override
    public List<Post> search(String keyWord) throws SQLException {
        return postDAO.search(keyWord);
    }

    public List<Post> selectLimit(int limit) throws SQLException {
        return postDAO.selectLimit(limit);
    }
}
