package com.booklidio.DatabaseDir;

import com.booklidio.UserDir.User;
import com.booklidio.UserDir.UserController;

public class DatabaseController {

    // USER CONTROLLER

    public static void addUser(String firstName, String lastName, String email, String password, String cellphone,
            int marketing) {
        UserController.addUser(firstName, lastName, email, password, cellphone, marketing);
    }

    public static User getUser(int id) {
        return UserController.getUser(id);
    }

    public static User getUser(String email, String password) {
        return UserController.getUser(email, password);
    }

    public static void removeUser(User user) {
        UserController.removeUser(user);
    }

}
