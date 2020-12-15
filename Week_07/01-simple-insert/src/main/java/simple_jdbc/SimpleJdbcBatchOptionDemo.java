package simple_jdbc;

import java.sql.*;

public class SimpleJdbcBatchOptionDemo {


    // use rewriteBatchedStatements=true
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nantest?" +
                        "useUnicode=true&characterEncoding=UTF-8" +
                        "&rewriteBatchedStatements=true",
                "root",
                "root"
        );

        String insertSql = "INSERT INTO customers (CUSTOMER_ID) VALUES (?)";

        long start = System.currentTimeMillis();

        PreparedStatement ps = connection.prepareStatement(insertSql);

        Statement statement = connection.createStatement();

        statement.executeUpdate("TRUNCATE TABLE customers");

        for (int i = 1; i < 1000000; i++) {
            ps.setString(1, String.valueOf(i));
            ps.addBatch();

            //doing in 100 batch
            if (i % 1000 == 0) {
                ps.executeBatch();
            }
        }
        ps.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println("taking: " + (end - start) + " nano seconds");

        ps.close();
        statement.close();
        connection.close();

    }
}
