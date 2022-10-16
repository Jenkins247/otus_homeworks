package hometask3.tables;

import hometask3.entities.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Students extends AbsTable {
    public Students() {
        super("Students", new ArrayList<>() {{
            add("id int");
            add("fullName varchar(50)");
            add("gender varchar(50)");
            add("groupId int");
        }});

    }

    public void insertRows(Student student) throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s (id, fullName, gender, groupId) VALUES (%s, '%s', '%s', %s);",
                getTableName(),
                student.getId(),
                student.getFullName(),
                student.getGender(),
                getIdAllRows("StudyGroups").stream().skip(
                                new Random().nextInt(getIdAllRows("StudyGroups").size()))
                        .findFirst().orElse(null)), false);
    }
}
