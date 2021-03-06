package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBDAO implements IBaseDAO<User> {
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM blogdemo.users;";
    private static final String SQL_INSERT_USER_SQL = "INSERT INTO `blogdemo`.`users` (`email`, `alias`, `password`, `role`, `fullname`, `yob`, `description`, `about`, `image`) VALUES (?, ?, sha1(?), ?, ?, ?, ?, ?, ?);";
    private static final String SQL_REGISTER_USER_SQL = "INSERT INTO `blogdemo`.`users` (`email`,`password`, `fullname`) VALUES (?,sha1(?),?);";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM blogdemo.users where id=?";
    private static final String SQL_UPDATE_USER = "UPDATE `blogdemo`.`users` SET `email` = ?, `alias` = ?, `role` = ?, `fullname` = ?, `yob` = ?, `description` = ?, `about` = ?, `image` = ? WHERE (`id` = ?);";
    private static final String SQL_DELETE_USER = "DELETE FROM `blogdemo`.`users` WHERE (`id` = ?);";
    private static final String SQL_DELETE_USER_FK_POST = "DELETE FROM `blogdemo`.`posts` WHERE (`idpost` = ?);";
    private static final String SQL_FIND_ALL_POSTS_BY_USER = "";
    private static final String SQL_SELECT_USERS_TO_LOGIN= "SELECT * FROM `blogdemo`.`users` where email=? and password=?";

    @Override
    public List<User> selectAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String alias = rs.getString("alias");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                String fullName = rs.getString("fullname");
                int yob = rs.getInt("yob");
                String description = rs.getString("description");
                String about = rs.getString("about");
                String createdDate = rs.getString("createddate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(createdDate, dateTimeFormatter);
                String image = rs.getString("image");
                userList.add(new User(id, email, alias, password, role, fullName, yob, description, about, localDateTime, image));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getAlias());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getRole());
            preparedStatement.setString(5, user.getFullName());
            preparedStatement.setInt(6, user.getYob());
            preparedStatement.setString(7, user.getDescription());
            preparedStatement.setString(8, user.getAbout());
            preparedStatement.setString(9, user.getImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void register(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REGISTER_USER_SQL)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String alias = rs.getString("alias");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                String fullName = rs.getString("fullname");
                int yob = rs.getInt("yob");
                String description = rs.getString("description");
                String about = rs.getString("about");
                String createdDate = rs.getString("createddate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(createdDate, dateTimeFormatter);
                String image = rs.getString("image");
                user = new User(id, email, alias, password, role, fullName, yob, description, about, localDateTime, image);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getAlias());
            statement.setInt(3, user.getRole());
            statement.setString(4, user.getFullName());
            statement.setInt(5, user.getYob());
            statement.setString(6, user.getDescription());
            statement.setString(7, user.getAbout());
            statement.setString(8, user.getImage());
            statement.setInt(9, user.getId());
            System.out.println(statement);
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_FK_POST);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            rowDeleted = statement.executeUpdate() > 0;
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException ex) {
            printSQLException(ex);
            connection.rollback();
            connection.close();
        }
        return rowDeleted;
    }

    @Override
    public List<User> search(String keyword) throws SQLException {
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public User findByEmailAndPass(String email,String password) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_TO_LOGIN)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");
                String alias = rs.getString("alias");
                int role = rs.getInt("role");
                String fullName = rs.getString("fullname");
                int yob = rs.getInt("yob");
                String description = rs.getString("description");
                String about = rs.getString("about");
                String createdDate = rs.getString("createddate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(createdDate, dateTimeFormatter);
                String image = rs.getString("image");
                user = new User(id, email, alias, password, role, fullName, yob, description, about, localDateTime, image);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

}
