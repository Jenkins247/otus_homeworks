package hometask3.tables;

import hometask3.entities.Curator;

import java.sql.SQLException;
import java.util.ArrayList;

public class Curators extends AbsTable {
    public Curators() {
        super("Curators", new ArrayList<>() {{
            add("id int");
            add("fullName varchar(50)");
        }});
    }

    public void insertRows(Curator curator) throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s (id, fullName) VALUES (%s, '%s');",
                getTableName(),
                curator.getId(),
                curator.getFullName()), false);

    }


}
