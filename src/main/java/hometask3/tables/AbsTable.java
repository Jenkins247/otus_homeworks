package hometask3.tables;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbsTable implements ITable {

    private String tableName;
    private List<String> columns;
    protected IDbExecutor iDbExecutor;

    public IDbExecutor getiDbExecutor() {
        return iDbExecutor;
    }

    public AbsTable(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = columns;
        this.iDbExecutor = new MySqlDbExecutor();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public void create() throws SQLException{

        if (isTableExists()) {
            this.delete();
        }
        iDbExecutor.execute(String.format("CREATE TABLE %s (%s);",
                       tableName, String.join(", ", columns)),
                false);
    }

    @Override
    public void delete() throws SQLException {
        iDbExecutor.execute(String.format("DROP TABLE %s", this.tableName), false);
    }



    protected boolean isTableExists() throws SQLException {
        ResultSet tables = iDbExecutor.execute("show tables;", true);
        while (tables.next()) {
            if (tables.getString(1).equals(tableName)) {
                return true;
            }
        }
        return false;
    }

    public Set<Integer> getIdAllRows(String tableName) throws SQLException {
        Set<Integer> idList = new HashSet<>();
        ResultSet result = iDbExecutor.execute(String.format("SELECT id FROM %s", tableName), true);
        while(result.next()){
            idList.add(result.getInt("id"));
        }
        return idList;
    }

    protected String createPredicate(String[] predicateValues) {
        return String.format("where %s", String.join(" and ", predicateValues));

    }

}
