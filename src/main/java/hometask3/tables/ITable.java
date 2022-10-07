package hometask3.tables;

import java.sql.SQLException;

public interface ITable {
    void create() throws SQLException;
    void delete() throws SQLException;

}
