package simple_jdbc;

import java.sql.*;

public class SimpleJdbcDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nantest", "root", "root"
        );

        String insertSql = "INSERT INTO customers (CUSTOMER_ID) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

        //taking: 24656347nano seconds for 1 mill
        //
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1, String.valueOf(i));
            preparedStatement.executeUpdate();
        }

        System.out.println("batch added");

        long end = System.currentTimeMillis();
        System.out.println("taking: " + (end - start) + " nano seconds");

        preparedStatement.close();
        connection.close();

    }
}
