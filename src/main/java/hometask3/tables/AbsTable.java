package hometask3.tables;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbsTable implements ITable<AbsTable> {

    private String tableName;
    protected IDbExecutor iDbExecutor;

    public IDbExecutor getiDbExecutor() {
        return iDbExecutor;
    }

    public AbsTable(String tableName) {
        this.tableName = tableName;
        this.iDbExecutor = new MySqlDbExecutor();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public void create(AbsTable table) throws SQLException {


    }

    @Override
    public void delete() throws SQLException {
        iDbExecutor.execute(String.format("DROP TABLE %s", this.tableName), false);
    }

    protected boolean isTableExists(String tableName) throws SQLException {
        ResultSet tables = iDbExecutor.execute("show tables;", true);
        while (tables.next()) {
            if (tables.getString(1).equals(tableName)) {
                return true;
            }
        }
        return false;
    }

    protected String createPredicate(String[] predicateValues) {
        return String.format("where %s", String.join(" and ", predicateValues));

    }

}
