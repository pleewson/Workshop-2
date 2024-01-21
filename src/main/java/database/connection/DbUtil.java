package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root2612";

    public static Connection getConnection() throws SQLException {
       Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
       return conn;
    }

}
