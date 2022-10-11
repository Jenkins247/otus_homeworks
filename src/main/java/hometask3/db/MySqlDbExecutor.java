package hometask3.db;
import hometask3.utils.resources.IResources;
import hometask3.utils.resources.PropertiesReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MySqlDbExecutor implements IDbExecutor {
    private static Connection connection = null;
    private static Statement statement = null;

    @Override
    public ResultSet execute(String sqlRequest, boolean isResult) throws SQLException {
        IResources resources = new PropertiesReader();

        Map<Integer, String> result = new HashMap<>();
        Map<String, String> props = resources.read();

        String url = String.format("%s/%s", props.get("url"), props.get("db_name"));


        if (connection == null) {
            connection = DriverManager.getConnection(url, props.get("username"), props.get("password"));
            statement = connection.createStatement();
        }

        if (isResult) {

            return statement.executeQuery(sqlRequest);

        }

        statement.execute(sqlRequest);
        return null;


    }
    @Override
    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}




