package database.connection;

import java.sql.*;

import entity.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    //CRUD

    //close PreparedStatement, ResultSet?

    public User createUser(User user) {
        final String CREATE_USER_QUERY = "INSERT INTO users (email, userName, password) VALUES (?, ?, ?);";

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preStmt = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStmt.setString(1, user.getEmail());
            preStmt.setString(2, user.getUserName());
            preStmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            preStmt.executeUpdate();

            ResultSet rs = preStmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            System.out.println("New User have been created!");
            return user;
        } catch (SQLException ex) {
            System.out.println("Problems with creating new User.");
            ex.printStackTrace();
            throw new RuntimeException("Error creating user", ex);

        }
    }


//    public static void printAllUsers() {
//        final String SELECT_USERS_QUERY = "SELECT * FROM users;";
//
//    }


}
