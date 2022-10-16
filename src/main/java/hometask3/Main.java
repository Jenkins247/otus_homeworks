package hometask3;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;
import hometask3.entities.Curator;
import hometask3.entities.Group;
import hometask3.entities.Student;
import hometask3.entities.enums.Groups;
import hometask3.tables.Curators;
import hometask3.tables.Students;
import hometask3.tables.StudyGroups;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDbExecutor iDbExecutor = new MySqlDbExecutor();

        Students student = new Students();
        StudyGroups group = new StudyGroups();
        Curators curator = new Curators();

        Curator curatorData = new Curator();
        Group groupData = new Group();
        Student studentData = new Student();


        try {
            curator.create();
            while (curatorData.getId() <= 4) {
                curator.insertRows(curatorData);
                curatorData.setId(curatorData.getId() + 1);
            }

            group.create();
            while (groupData.getId() <= 3) {
                for (Groups groupValue : Groups.values()) {
                    groupData.setName(groupValue.name());
                    group.insertRows(groupData);
                    groupData.setId(groupData.getId() + 1);
                }
            }

            student.create();
            while (studentData.getId() <= 15) {
                student.insertRows(studentData);
                studentData.setId(studentData.getId() + 1);
            }

        } finally {
            iDbExecutor.close();
        }

    }
}
