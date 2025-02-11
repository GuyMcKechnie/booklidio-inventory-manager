package com.booklidio.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseController {
    private static final Logger LOGGER = LogManager.getLogger();

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
            LOGGER.error("Exception during database connection: ", exception);
            return null;
        }
    }

    public static void addUser(String firstName, String lastName, String street, String city) {
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO userS VALUES (102, '" + firstName + "', '" + lastName + "', '" + street + "', '"
                    + city + "')";
            statement.executeUpdate(query);
            connection.commit();
        } catch (Exception exception) {
            LOGGER.error("Exception during user addition: ", exception);
        }
        LOGGER.info("Adding user with ID 101, name '{} {}', address '{} {}'",
                firstName, lastName, street, city);
    }
}
