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

public class PostDAO extends DBDAO implements IBaseDAO<Post> {
    private static final String INSERT_POST_SQL = "INSERT INTO `posts` (`title`, `fullcontent`, `shortcontent`, `image`, `idcategory`, `iduser`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_POSTS_BY_ID = "SELECT posts.*, categories.`name`, users.`email`, users.`fullname`, users.`image` as userimage, users.`description` FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id where idpost = ?;";
    private static final String SELECT_ALL_POSTS = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id order by lastedittime desc;";
    private static final String SELECT_ALL_POSTS_BY_USER = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id where posts.iduser=?;";
    private static final String SELECT_ALL_POSTS_BY_CATEGORY = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id where categories.id=? order by lastedittime desc;";
    private static final String SELECT_ALL_POSTS_LIMIT = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id order by lastedittime desc limit ?;";
    private static final String UPDATE_POST_SQL = "UPDATE `posts` SET `title` = ?, `fullcontent` = ?, `shortcontent` = ?, `image` = ?, `lastedittime`= now(), `idcategory` = ?, `iduser` = ? WHERE (`idpost` = ?);";
    private static final String DELETE_POST_SQL = "DELETE FROM `posts` WHERE (`idpost` = ?);";
    private static final String SEARCH_BY_NAME = "SELECT posts.*, categories.`name`, users.email FROM posts inner join categories on posts.idcategory = categories.id inner join users on posts.iduser = users.id where title like ?;";

    @Override
    public List<Post> selectAll() throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idpost");
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
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }

    public List<Post> selectAllPostUser(int idUser) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS_BY_USER)) {
            preparedStatement.setInt(1,idUser);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idpost");
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
                String categoryName = rs.getString("name");
                String email = rs.getString("email");
                Category category = new Category(idCategory, categoryName);
                User user = new User(idUser, email);
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }
    public List<Post> selectAllPostCategory(int idCategory) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS_BY_CATEGORY)) {
            preparedStatement.setInt(1,idCategory);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idpost");
                String postTitle = rs.getString("title");
                String fullContent = rs.getString("fullcontent");
                String shortContent = rs.getString("shortcontent");
                String createdDate = rs.getString("createddate");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(createdDate, dateTimeFormatter);
                String image = rs.getString("image");
                String lastEditTime = rs.getString("lastedittime");
                LocalDateTime localDateTime2 = LocalDateTime.parse(lastEditTime, dateTimeFormatter);
                String categoryName = rs.getString("name");
                String email = rs.getString("email");
                int idUser = rs.getInt("iduser");
                Category category = new Category(idCategory, categoryName);
                User user = new User(idUser, email);
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
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
                int idPost = rs.getInt("idpost");
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
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return postList;
    }

    @Override
    public void insert(Post post) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST_SQL)) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getFullContent());
            preparedStatement.setString(3, post.getShortContent());
            preparedStatement.setString(4, post.getImage());
            preparedStatement.setInt(5, post.getCategory().getId());
            preparedStatement.setInt(6, post.getUser().getId());
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
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSTS_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idpost");
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
                String fullName = rs.getString("fullname");
                String description = rs.getString("description");
                String imageUser = rs.getString("userimage");
                Category category = new Category(idCategory, categoryName);
                User user = new User(idUser, email, fullName, description, imageUser);
                post = new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user);
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
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getFullContent());
            statement.setString(3, post.getShortContent());
            statement.setString(4, post.getImage());
            statement.setInt(5, post.getCategory().getId());
            statement.setInt(6, post.getUser().getId());
            statement.setInt(7, post.getId());
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


    public List<Post> search(String keyWord) throws SQLException {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + keyWord + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt("idpost");
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
                postList.add(new Post(idPost, postTitle, fullContent, shortContent, localDateTime, image, localDateTime2, category, user));
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
