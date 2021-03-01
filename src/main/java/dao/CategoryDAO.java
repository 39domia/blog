package dao;

import model.Author;
import model.Category;
import model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBDAO implements IBaseDAO<Category> {
    private static final String INSERT_CATEGORY_SQL = "insert into category" + "(categoryName) values" +
            "(?);";
    private static final String SELECT_CATEGORY_BY_ID = "select * from category where idCategory = ?";
    private static final String SELECT_ALL_CATEGORIES = "select * from category";
    private static final String UPDATE_CATEGORY_SQL = "update category set categoryName = ? where idCategory = ?;";
    private static final String DELETE_CATEGORY_SQL = "delete from category where idCategory = ?;";
    private static final String DELETE_CATEGORY_FK_POST_SQL = "DELETE FROM post WHERE (idCategory = ?);";
    private static final String FIND_ALL_POST_BY_CATEGORY = "SELECT post.*, categoryName, authorName, authorDes  FROM post inner join category on post.idCategory = category.idCategory inner join author on post.idAuthor = author.idAuthor where post.idCategory = ?;";

    @Override
    public List<Category> selectAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCategory");
                String name = rs.getString("categoryName");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }

    @Override
    public void insert(Category category) throws SQLException {
        System.out.println(INSERT_CATEGORY_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategoryName());
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
                String name = rs.getString("categoryName");
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
            statement.setString(1, category.getCategoryName());
            statement.setInt(2, category.getIdCategory());
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
            statement.executeUpdate();
            statement = connection.prepareStatement(DELETE_CATEGORY_SQL);
            statement.setInt(1,id);
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
    public List<Category> search(String keyWord) throws SQLException {
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
                String postTitle = rs.getString("postTitle");
                String fullContent = rs.getString("fullContent");
                String shortContent = rs.getString("shortContent");
                String date = rs.getString("publishDate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
                String image = rs.getString("image");
                int idCategory = rs.getInt("idCategory");
                int idAuthor = rs.getInt("idAuthor");
                String categoryName = rs.getString("categoryName");
                String authorName = rs.getString("authorName");
                String authorDes = rs.getString("authorDes");
                Category category = new Category(idCategory, categoryName);
                Author author = new Author(idAuthor, authorName, authorDes);
                postList.add(new Post(idCategoryFind, postTitle, fullContent, shortContent, localDateTime, image, category, author));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }
}
