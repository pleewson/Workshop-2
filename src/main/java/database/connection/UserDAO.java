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


    public User read(int userId) {
        final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = " + userId;

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preStmt = conn.prepareStatement(SELECT_USER_BY_ID_QUERY)) {

            User userToRead = new User();
            ResultSet resultSet = preStmt.executeQuery();

            if (resultSet.next()) {
                userToRead.setId(resultSet.getInt("id"));
                userToRead.setEmail(resultSet.getString("email"));
                userToRead.setUserName(resultSet.getString("username"));
                userToRead.setPassword(resultSet.getString("password"));

                System.out.println("Loading data -possitive");
                return userToRead;
            } else {
                System.out.println("No user found with ID " + userId);
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Problem with loading data");
            return null;
        }

    }

    public void delete(int userId){

    }


}
