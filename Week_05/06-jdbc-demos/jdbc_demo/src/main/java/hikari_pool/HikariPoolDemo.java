package hikari_pool;

import connection_pool_jdbc.ConnectionPool;
import util.StatementUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariPoolDemo {
    public static void main(String[] args) throws SQLException {


        Connection connection = HikariPool.getConnection();
        Connection connection1 = HikariPool.getConnection();
        Connection connection2 = HikariPool.getConnection();

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
    }
}
