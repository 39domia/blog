package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IBaseService<User> {
    UserDAO userDAO = new UserDAO();

    @Override
    public List<User> selectAll() throws SQLException {
        return userDAO.selectAll();
    }

    @Override
    public void insert(User user) throws SQLException {
        userDAO.insert(user);
    }

    public void register(User user) throws SQLException {
        userDAO.register(user);
    }

    @Override
    public User findById(int id) throws SQLException {
        return userDAO.findById(id);
    }

    @Override
    public boolean update(User user) throws SQLException {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return userDAO.delete(id);
    }

    @Override
    public List<User> search(String keyWord) throws SQLException {
        return userDAO.search(keyWord);
    }

    public User findByUserAndPassword(String email,String password) throws SQLException {
        return userDAO.findByEmailAndPass(email,password);
    }
}
