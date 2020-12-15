package simple_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleJdbcBatchDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nantest", "root", "root"
        );

        String insertSql = "INSERT INTO customers (CUSTOMER_ID) VALUES (?)";

        long start = System.currentTimeMillis();

        PreparedStatement ps = connection.prepareStatement(insertSql);


        for (int i = 1; i < 10000; i++) {
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
        connection.close();

    }
}
