package entity;

import database.connection.UserDAO;

public class test {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        User user1;
        user1 = userDAO.read(2);

        System.out.println("id " + user1.getId());
        System.out.println("username " + user1.getUserName());
        System.out.println("password " + user1.getPassword());
        System.out.println("email " + user1.getEmail());


//        user1.setUserName("Jhony");
//        user1.setPassword("password123");
//        user1.setEmail("Jhonyemail@gmail.com");





    }
}
