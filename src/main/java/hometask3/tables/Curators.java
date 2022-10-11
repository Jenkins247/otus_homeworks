package hometask3.tables;

import java.sql.SQLException;

public class Curators extends AbsTable{
    private final static String ID = "id int";
    private final static String FULLNAME = "full_name varchar(50)";

    public Curators() {
        super("Curators");
    }

    @Override
    public void create(AbsTable table) throws SQLException {
            if (isTableExists(getTableName())) {
                table.delete();
            }
            iDbExecutor.execute(String.format("CREATE TABLE %s (%s, %s);",
                            getTableName(), ID, FULLNAME),
                    false);
    }
}
