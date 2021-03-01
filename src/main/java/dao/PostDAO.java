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

public class PostDAO extends DBDAO implements IBaseDAO<Post> {
    private static final String INSERT_POST_SQL = "INSERT INTO post (postTitle, fullContent, shortContent, image, idCategory, idAuthor) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_POST_BY_ID = "SELECT post.*, categoryName, authorName, authorDes  FROM post inner join category on post.idCategory = category.idCategory inner join author on post.idAuthor = author.idAuthor where idPost= ?";
    private static final String SELECT_ALL_POSTS = "SELECT post.*, categoryName, authorName FROM post inner join category on post.idCategory = category.idCategory" +
            " inner join author on post.idAuthor = author.idAuthor;";
    private static final String SELECT_ALL_POSTS_LIMIT = "SELECT post.*, categoryName, authorName FROM post inner join category on post.idCategory = category.idCategory" +
            " inner join author on post.idAuthor = author.idAuthor limit ?;";
    private static final String UPDATE_POST_SQL = "UPDATE post SET postTitle = ?, fullContent = ?, shortContent = ?, image = ?, idCategory = ?, idAuthor = ? WHERE (idPost = ?);";
    private static final String DELETE_POST_SQL = "delete from post where idPost = ?;";
    private static final String SEARCH_BY_NAME = "SELECT post.*, categoryName, authorName FROM post inner join category on post.idCategory = category.idCategory" +
            " inner join author on post.idAuthor = author.idAuthor where postTitle = ?;";

    @Override
    public List<Post> selectAll() throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idPost");
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
                Category category = new Category(idCategory, categoryName);
                Author author = new Author(idAuthor, authorName);
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, category, author));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }
    public List<Post> selectLimit(int limit) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS_LIMIT)) {
            preparedStatement.setInt(1, limit);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idPost");
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
                Category category = new Category(idCategory, categoryName);
                Author author = new Author(idAuthor, authorName);
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, category, author));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }

    @Override
    public void insert(Post post) throws SQLException {
//        System.out.println(INSERT_POST_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST_SQL)) {
            preparedStatement.setString(1, post.getPostTitle());
            preparedStatement.setString(2, post.getFullContent());
            preparedStatement.setString(3, post.getShortContent());
            preparedStatement.setString(4, post.getImage());
            preparedStatement.setInt(5, post.getCategory().getIdCategory());
            preparedStatement.setInt(6, post.getAuthor().getIdAuthor());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Post findById(int id) throws SQLException {
        Post post = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POST_BY_ID)) {
            preparedStatement.setInt(1, id);
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
                post = new Post(id, postTitle, fullContent, shortContent, localDateTime, image, category, author);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return post;
    }

    @Override
    public boolean update(Post post) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_POST_SQL);) {
            statement.setString(1, post.getPostTitle());
            statement.setString(2, post.getFullContent());
            statement.setString(3, post.getShortContent());
            statement.setString(4, post.getImage());
            statement.setInt(5, post.getCategory().getIdCategory());
            statement.setInt(6, post.getAuthor().getIdAuthor());
            statement.setInt(7, post.getIdPost());
            System.out.println(statement);
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_POST_SQL)) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Post> search(String keyWord) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS)) {
            preparedStatement.setString(1, keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idPost");
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
                Category category = new Category(idCategory, categoryName);
                Author author = new Author(idAuthor, authorName);
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, category, author));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
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
}
