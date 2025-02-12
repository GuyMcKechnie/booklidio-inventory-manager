package com.booklidio.UserDir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
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

    public static void addUser(String firstName, String lastName, String email, String password, String cellphone,
            int marketing) {
        Connection connection = connect();

        if (checkUserExists(email) == true) {
            LOGGER.info("User with email `{}` already exists.", email);
            System.out.println("User already exists.");
            return;
        }

        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO users (firstName, lastName, email, password, cellphone, marketing) VALUES ('"
                    + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + cellphone + "', '"
                    + marketing + "');";
            statement.executeUpdate(query);
            connection.commit();
        } catch (Exception exception) {
            LOGGER.error("Exception during user addition: ", exception);
        }
        LOGGER.info("Added user with name '{} {}'", firstName, lastName);
    }

    public static void removeUser(User user) {
        Connection connection = connect();
        int id = user.getId();
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM users WHERE id ='" + id + "'";
            statement.executeUpdate(query);
            connection.commit();
        } catch (Exception exception) {
            LOGGER.error("Exception during user removal: ", exception);
        }
        LOGGER.info("Removed user with id '{}'", id);
    }

    public static User getUser(int id) {
        Connection connection = connect();
        ResultSet userResult = null;
        User user = null;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE id ='" + id + "'";
            userResult = statement.executeQuery(query);
            connection.commit();

            if (userResult.next() == false) {
                return null;
            }

            String firstName = userResult.getString("firstName");
            String lastName = userResult.getString("lastName");
            String email = userResult.getString("email");
            String password = userResult.getString("password");
            String cellphone = userResult.getString("cellphone");
            int marketing = userResult.getInt("marketing");

            user = new User(id, firstName, lastName, email, password, cellphone, marketing);

        } catch (Exception exception) {
            LOGGER.error("Exception during user selection: ", exception);
        }
        LOGGER.info("Selected user with id '{}'", id);
        return user;
    }

    public static User getUser(String email, String password) {
        Connection connection = connect();
        User user = null;
        int storedId = -1;
        String storedPassword = null;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, password FROM users WHERE email ='" + email + "'";
            ResultSet authenticationResultSet = statement.executeQuery(query);
            connection.commit();

            if (!authenticationResultSet.next()) {
                return null;
            }

            storedId = authenticationResultSet.getInt("id");
            storedPassword = authenticationResultSet.getString("password");
            if (storedPassword.equals(password)) {
                user = getUser(storedId);
            }
        } catch (Exception exception) {
            LOGGER.error("Exception during user selection: ", exception);
        }
        LOGGER.info("Selected user with id '{}'", storedId);
        return user;
    }

    private static boolean checkUserExists(String email) {
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE email ='" + email + "'";
            ResultSet userResult = statement.executeQuery(query);
            connection.commit();

            if (userResult.next() == false) {
                return false;
            }
        } catch (Exception exception) {
            LOGGER.error("Exception during user existence check: ", exception);
        }
        return true;
    }
}
