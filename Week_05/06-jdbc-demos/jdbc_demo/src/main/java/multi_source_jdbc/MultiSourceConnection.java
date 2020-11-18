package multi_source_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MultiSourceConnection {
    private static Map<String, Connection> connectionMap = new HashMap<>();

    public MultiSourceConnection(String url, String username, String password) throws SQLException {
        String mapKey = url + username;

        if (connectionMap.containsKey(mapKey)) {
            //do nothing as conneciton already exists
        } else {
            Connection connection = DriverManager.getConnection(url, username, password);
            connectionMap.put(mapKey, connection);
        }
    }

    public Connection getConnection(String url, String username) {
        return connectionMap.get(url + username);
    }
}
