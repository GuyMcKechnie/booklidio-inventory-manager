package com.booklidio.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseController {

    private static final Logger LOGGER = LogManager.getLogger();

    private static Connection connection = null;

    public static void setConnection() {
        try {
            // Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            LOGGER.info("Attempting to connect to database.");
            DatabaseController.connection = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/booklidioDatabase", "SA",
                    "");
            if (connection == null) {
                return;
            }
            LOGGER.info("Connection `{}` to database was successful.", connection);
        } catch (Exception exception) {
            LOGGER.error("Exception during database connection: " + exception.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void insertUser(String query) {
        PreparedStatement statement;
        try {
            statement = getConnection().prepareStatement(query);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
        }
    }
}
