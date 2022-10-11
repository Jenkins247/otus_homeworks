package hometask3.tables;

import java.sql.SQLException;

public interface ITable<T> {
    void create(T t) throws SQLException;
    void delete() throws SQLException;

}
