package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementUtil {
    public static PreparedStatement getByFirstName(Connection connection, String first_name) throws SQLException {
        String psSql = "SELECT * FROM BILLIONAIRES WHERE FIRST_NAME = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(psSql);
        preparedStatement.setString(1, first_name);
        return preparedStatement;
    }
}
