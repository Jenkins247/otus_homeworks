package hometask3.tables;

import java.sql.SQLException;

public class StudyGroups extends AbsTable{

    private final static String ID = "id int";
    private final static String NAME = "name varchar(50)";
    private final static String CURATOR_ID = "curator_id int";

    public StudyGroups() {
        super("StudyGroups");
    }


    @Override
    public void create(AbsTable table) throws SQLException {
            if (isTableExists(getTableName())) {
                table.delete();
            }
            iDbExecutor.execute(String.format("CREATE TABLE %s (%s, %s, %s)",
                            getTableName(), ID, NAME, CURATOR_ID), false);
    }
}
