package com.booklidio;

import com.booklidio.DatabaseDir.DatabaseController;

public class Main {
    public static void main(String[] args) {
        DatabaseController.addUser("Guy", "McKechnie", "guy@gmail.com", "Password123", "012 345 6789", 0);
        DatabaseController.addUser("Amy", "McKechnie", "amy@gmail.com", "Password567", "987 654 3210", 1);
        System.out.println(DatabaseController.getUser("amy@gmail.com", "Password567"));
        System.out.println(DatabaseController.getUser("guy@gmail.com", "Password123"));
        // DatabaseController.removeUser(DatabaseController.getUser("amy@gmail.com",
        // "Password567"));
        // DatabaseController.removeUser(DatabaseController.getUser("guy@gmail.com",
        // "Password123"));
    }
}