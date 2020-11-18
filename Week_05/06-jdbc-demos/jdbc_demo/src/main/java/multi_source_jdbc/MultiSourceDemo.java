package multi_source_jdbc;

import multi_source_jdbc.MultiSourceConnection;
import util.StatementUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiSourceDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:tcp://localhost:9090/mem:testdb";
        String username = "sa";
        String password = "password";

        MultiSourceConnection mscp = new MultiSourceConnection(url, username, password);
        Connection connection = mscp.getConnection(url, username);

        // Prepared Statement
        PreparedStatement preparedStatement = StatementUtil.getByFirstName(connection, "Bill");
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString(1) + resultSet1.getString(2) + resultSet1.getString(3) + resultSet1.getString(4));
        }

        resultSet1.close();
        preparedStatement.close();

    }
}
