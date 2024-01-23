package entity;

import database.connection.DbUtil;
import database.connection.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//
        UserDAO userDAO = new UserDAO();
//
//        User user1;
//        user1 = userDAO.read(2);
//
//        System.out.println("id " + user1.getId());
//        System.out.println("username " + user1.getUserName());
//        System.out.println("password " + user1.getPassword());
//        System.out.println("email " + user1.getEmail());
//
//        user1.setUserName("Paolo");
//
////        userDAO.update(user1);


//        User user22 = new User();
//
//        user22.setUserName("Camillo");
//        user22.setEmail("Camillo12@gmail.com");
//        user22.setPassword("C4M1ll0");

//        userDAO.delete(3);

        List<User> allUsers = new ArrayList<>();

        allUsers = userDAO.findAll();

        System.out.println(allUsers);

        System.out.println("email 2nd user " + allUsers.get(1).getEmail());

    }
}
