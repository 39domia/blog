package service;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {
    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    T findById(int id) throws SQLException;

    boolean update(T t) throws  SQLException;

    boolean delete(int id ) throws SQLException;

    List<T> search(String keyWord) throws SQLException;

}
