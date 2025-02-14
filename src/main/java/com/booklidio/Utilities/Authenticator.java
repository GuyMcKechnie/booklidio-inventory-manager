package com.booklidio.Utilities;

import com.booklidio.Database.DatabaseController;

public class Authenticator {
    public static boolean authenticateUser(String email, String password) {
        if (DatabaseController.getUser(email, password) != null) {
            return true;
        }
        return false;
    }
}
