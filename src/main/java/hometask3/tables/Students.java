package hometask3.tables;

import java.sql.SQLException;

public class Students extends AbsTable{

    private final static String ID = "id int";
    private final static String FULLNAME = "full_name varchar(50)";
    private final static String SEX = "sex varchar(50)";
    private final static String GROUP_ID = "group_id int";

    public Students() {
        super("Students");

    }


    @Override
    public void create(AbsTable table) throws SQLException {

            if (isTableExists(getTableName())) {
                table.delete();
            }
            iDbExecutor.execute(String.format("CREATE TABLE %s (%s, %s, %s, %s);",
                            getTableName(), ID, FULLNAME, SEX, GROUP_ID),
                    false);

    }
}
