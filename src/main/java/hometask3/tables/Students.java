package hometask3.tables;

import hometask3.entities.Student;

import java.sql.ResultSet;
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

    public ResultSet getFemaleStudents() throws SQLException {
        String[] predicateValues = {"gender = 'Женский'"};

       ResultSet result = iDbExecutor.execute(String.format("SELECT * FROM %s %s",
                getTableName(),
                createPredicate(predicateValues)),
                true);

        return result;

    }

    public ResultSet getStudentsWithGroupsAndCurators() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("SELECT \n" +
                "  Students.*, \n" +
                "  StudyGroups.name as GroupName,\n" +
                "  Curators.fullName as CuratorName\n" +
                "FROM Students\n" +
                "JOIN StudyGroups ON Students.groupId = StudyGroups.id\n" +
                "JOIN Curators ON StudyGroups.curatorId = Curators.id;"), true);
        return result;
    }
    public ResultSet getCount() throws SQLException{
        ResultSet result = iDbExecutor.execute(String.format("SELECT COUNT('id') FROM %s",
                getTableName()), true);
        return result;
    }

    public ResultSet getStudentsByGroup() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("SELECT * FROM Students\n" +
                "WHERE groupId IN (\n" +
                "  SELECT id FROM StudyGroups\n" +
                "  WHERE name = 'История'\n" +
                ");"), true);
        return result;
    }
}
