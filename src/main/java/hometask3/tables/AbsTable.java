package hometask3.tables;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;
import org.apache.commons.compress.archivers.zip.X0017_StrongEncryptionHeader;

import java.sql.SQLException;
import java.util.List;

public class AbsTable implements ITable{

    private String tableName;
    protected IDbExecutor iDbExecutor;

    public IDbExecutor getiDbExecutor() {
        return iDbExecutor;
    }

    public AbsTable(String tableName){
        this.tableName = tableName;
        this.iDbExecutor = new MySqlDbExecutor();
    }

    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("CREATE TABLE %s (name varchar(25), lastname varchar(25));", this.tableName), false);
    }

    @Override
    public void delete() throws SQLException {
        iDbExecutor.execute(String.format("DROP TABLE %s", this.tableName), false);
    }

    protected String createPredicate(String[] predicateValues){
        return String.format("where %s", String.join(" and ", predicateValues));

    }
}
