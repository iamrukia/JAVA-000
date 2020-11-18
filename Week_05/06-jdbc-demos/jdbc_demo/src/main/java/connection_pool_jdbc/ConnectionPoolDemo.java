package connection_pool_jdbc;

import util.StatementUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPoolDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:tcp://localhost:9090/mem:testdb";
        String username = "sa";
        String password = "password";
        ConnectionPool connectionPool = ConnectionPool.create(url, username, password);

        Connection connection = connectionPool.getConnection();
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();

        // Prepared Statement
        PreparedStatement preparedStatement = StatementUtil.getByFirstName(connection, "Aliko");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        resultSet.close();
        preparedStatement.close();


        PreparedStatement preparedStatement1 = StatementUtil.getByFirstName(connection, "Bill");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString(2));
        }

        resultSet1.close();
        preparedStatement1.close();


        PreparedStatement preparedStatement2 = StatementUtil.getByFirstName(connection, "Folrunsho");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString(4));
        }

        resultSet2.close();
        preparedStatement2.close();

        System.out.println("Connection Pool size: " + connectionPool.getSize());
        System.out.println("Remaining available connection: " + connectionPool.getAvailableSize());

        connectionPool.releaseConnection(connection);
        connectionPool.releaseConnection(connection1);
        connectionPool.releaseConnection(connection2);

        //expect all 4 connections
        System.out.println("closing all connections...");
        System.out.println("Connection Pool size: " + connectionPool.getSize());
        System.out.println("Remaining available connection: " + connectionPool.getAvailableSize());
    }
}
