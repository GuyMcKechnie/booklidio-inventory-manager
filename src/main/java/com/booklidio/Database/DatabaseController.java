package com.booklidio.Database;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.User.User;
import com.booklidio.User.UserController;

public class DatabaseController {

    private static final Logger LOGGER = LogManager.getLogger();

    // MAIN CONNECTION
    public static final Connection connection = connect();

    public static void sendTo_addUser(String firstName, String lastName, String email, String cellphone,
            boolean marketing) {
        UserController.addUser(firstName, lastName, email, cellphone, marketing);
    }

    private static Connection connect() {
        try {
            // Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            LOGGER.info("Attempting to connect to database.");
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/booklidioDatabase", "SA",
                    "");
            if (connection == null) {
                return null;
            }
            LOGGER.info("Connection `{}` to database was successful.", connection);
            return connection;
        } catch (Exception exception) {
            LOGGER.error("Exception during database connection: " + exception.getMessage());
            return null;
        }
    }
}
