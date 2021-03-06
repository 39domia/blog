package dao;

import model.Category;
import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBDAO implements IBaseDAO<Category> {
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO `blogdemo`.`categories` (`name`) VALUES (?);";
    private static final String SELECT_CATEGORY_BY_ID = "select * from categories where `id` = ?";
    private static final String SELECT_ALL_CATEGORIES = "select * from categories";
    private static final String UPDATE_CATEGORY_SQL = "UPDATE `blogdemo`.`categories` SET `name` = ? WHERE (`id` = ?);";
    private static final String DELETE_CATEGORY_SQL = "delete from categories where id = ?;";
    private static final String DELETE_CATEGORY_FK_POST_SQL = "DELETE FROM posts WHERE (idcategory = ?);";
    private static final String FIND_ALL_POST_BY_CATEGORY = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id where posts.idcategory = ?;";

    @Override
    public List<Category> selectAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }

    @Override
    public void insert(Category category) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Category findById(int id) throws SQLException {
        Category category = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            System.out.println(statement);
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        Connection connection = getConnection();
        try
        {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_FK_POST_SQL);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
            statement = connection.prepareStatement(DELETE_CATEGORY_SQL);
            statement.setInt(1,id);
            System.out.println(statement);
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
    public List<Category> search(String keyword) throws SQLException {
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

    public List<Post> findAllPostByCategory(int idCategoryFind) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_POST_BY_CATEGORY)) {
            preparedStatement.setInt(1, idCategoryFind);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String postTitle = rs.getString("title");
                String fullContent = rs.getString("fullcontent");
                String shortContent = rs.getString("shortcontent");
                String createdDate = rs.getString("createddate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(createdDate, dateTimeFormatter);
                String image = rs.getString("image");
                String lastEditTime = rs.getString("lastedittime");
                LocalDateTime localDateTime2 = LocalDateTime.parse(lastEditTime, dateTimeFormatter);
                int idCategory = rs.getInt("idcategory");
                int idUser = rs.getInt("iduser");
                String categoryName = rs.getString("name");
                String email = rs.getString("email");
                Category category = new Category(idCategory, categoryName);
                User user = new User(idUser, email);
                postList.add(new Post(idCategoryFind, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }
}
