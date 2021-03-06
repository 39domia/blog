package dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    T findById(int id) throws SQLException;

    boolean update(T t) throws  SQLException;

    boolean delete(int id ) throws SQLException;

    List<T> search(String keyword) throws SQLException;


}
