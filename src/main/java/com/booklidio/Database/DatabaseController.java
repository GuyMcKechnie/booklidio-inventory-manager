package com.booklidio.Database;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.User.Seller;
import com.booklidio.User.UserController;

import javafx.scene.control.TableView;

public class DatabaseController {

    private static final Logger LOGGER = LogManager.getLogger();

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public static void sendTo_addUser(String firstName, String lastName, String email, String cellphone,
            boolean marketing) {
        UserController.addUser(firstName, lastName, email, cellphone, marketing);
    }

    public static void sendTo_getSellers(TableView<Seller> tableView) {
        UserController.setSellersTable(tableView);
    }

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
}
