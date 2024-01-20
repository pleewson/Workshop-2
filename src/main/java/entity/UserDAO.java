package entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static database.connection.DbUtil.getConnection;

public class UserDAO {
    private static final String CREATE_USER_QUERY = "INSERT INTO users (email, userName, password) VALUES (?, ?, ?);";
//    private static final String READ_USER_QUERY = "SELECT "
    
    public static void createUser(String email, String userName, String password) {

        try (PreparedStatement preStmt = getConnection().prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preStmt.setString(1, email);
            preStmt.setString(2, userName);
            preStmt.setString(3, password);

            preStmt.executeUpdate();
            System.out.println("New User have been created!");
        } catch (SQLException ex) {
            System.out.println("Problems with creating new User.");
            System.out.println(ex.getMessage());

        }
    }


}
