package hometask3;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;
import hometask3.tables.AbsTable;
import hometask3.tables.Curators;
import hometask3.tables.StudyGroups;
import hometask3.tables.Students;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDbExecutor iDbExecutor = new MySqlDbExecutor();
        AbsTable student = new Students();
        AbsTable group = new StudyGroups();
        AbsTable curator = new Curators();


        try {
            student.create(student);
            group.create(group);
            curator.create(curator);


        } finally {
            iDbExecutor.close();
        }

    }
}
