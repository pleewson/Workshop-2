package entity;

import database.connection.UserDAO;

import java.util.List;

public class TaskManager {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user;

        List<User> allUsers = userDAO.findAll();

    }
}
