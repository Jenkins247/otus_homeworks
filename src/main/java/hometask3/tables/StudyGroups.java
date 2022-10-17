package hometask3.tables;

import hometask3.entities.Group;

import java.security.PublicKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class StudyGroups extends AbsTable{

    public StudyGroups() {
        super("StudyGroups", new ArrayList<>(){{
            add("id int");
            add("name varchar(50)");
            add("curatorId int");
        }});
    }




    public void insertRows(Group studyGroups) throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s (id, Name, curatorId) VALUES (%s, '%s', %s);",
                getTableName(),
                studyGroups.getId(),
                studyGroups.getName(),
                getIdAllRows("Curators").stream().skip(
                        new Random().nextInt(getIdAllRows("Curators").size()))
                        .findFirst().orElse(null)), false);
    }

    public ResultSet getGroupsWithCurators() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("Select StudyGroups.*, Curators.fullName as CuratorName" +
                " from StudyGroups JOIN Curators ON StudyGroups.curatorId = Curators.id;"), true);
        return result;
    }

    public void updateCuratorIdFromGroup(int groupId, int curatorId) throws SQLException{
        String[] predicateValues = {"id = " + groupId};
        iDbExecutor.execute(String.format(
                "UPDATE StudyGroups SET curatorId = %s %s;",
                curatorId, createPredicate(predicateValues)), false);
    }

    
}
