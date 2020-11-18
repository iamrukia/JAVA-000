package simple_jdbc;

import util.StatementUtil;

import java.sql.*;

public class SimpleJdbcDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost:9090/mem:testdb", "sa", "password"
        );

        // Normal Statement
        String stSql = "SELECT FIRST_NAME FROM BILLIONAIRES";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(stSql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        resultSet.close();
        statement.close();

        // Prepared Statement

        PreparedStatement preparedStatement = StatementUtil.getByFirstName(connection, "Bill");

        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString(1));
        }

        resultSet1.close();
        preparedStatement.close();
    }
}
