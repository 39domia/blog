package dao;

import model.Author;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO extends DBDAO implements IBaseDAO<Author> {
    private static final String INSERT_AUTHOR_SQL = "insert into author" + "(authorName, authorDes) values" +
            "(?, ?);";
    private static final String SELECT_AUTHOR_BY_ID = "select * from author where idAuthor = ?";
    private static final String SELECT_ALL_AUTHORS = "select * from author";
    private static final String UPDATE_AUTHOR_SQL = "update author set authorName = ?, authorDes=? where idAuthor = ?;";
    private static final String DELETE_AUTHOR_SQL = "delete from author where idAuthor = ?;";
    private static final String DELETE_AUTHOR_FK_POST_SQL = "DELETE FROM post WHERE (idAuthor = ?);";
    private static final String SEARCH_BY_AUTHOR_NAME = "select * from author where authorName like ?";

    @Override
    public List<Author> selectAll() throws SQLException {
        List<Author> authorList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idAuthor = rs.getInt("idAuthor");
                String authorName = rs.getString("authorName");
                String authorDes = rs.getString("authorDes");
                authorList.add(new Author(idAuthor, authorName, authorDes));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return authorList;
    }

    @Override
    public void insert(Author author) throws SQLException {
        System.out.println(INSERT_AUTHOR_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
            preparedStatement.setString(1, author.getAuthorName());
            preparedStatement.setString(2, author.getAuthorDes());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Author findById(int id) throws SQLException {
        Author author = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String authorName = rs.getString("authorName");
                String authorDes = rs.getString("authorDes");
                author = new Author(id, authorName, authorDes);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return author;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL);) {
            statement.setString(1, author.getAuthorName());
            statement.setString(2, author.getAuthorDes());
            statement.setInt(3, author.getIdAuthor());
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
            PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR_FK_POST_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement = connection.prepareStatement(DELETE_AUTHOR_SQL);
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
    public List<Author> search(String keyWord) throws SQLException {
        List<Author> authorList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_AUTHOR_NAME)) {
            preparedStatement.setString(1, "%" + keyWord + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idAuthor = rs.getInt("idAuthor");
                String authorName = rs.getString("authorName");
                String authorDes = rs.getString("authorDes");
                Author author = new Author(idAuthor, authorName, authorDes);
                authorList.add(author);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return authorList;
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
