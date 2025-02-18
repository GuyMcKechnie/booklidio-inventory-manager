package com.booklidio.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.Database.DatabaseController;
import com.booklidio.Frontend.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class UserController {
    private static final Logger LOGGER = LogManager.getLogger();

    DatabaseController databaseController = new DatabaseController();

    private final Models models = new Models();

    public List<User> getUsers() {
        final List<User> users = new ArrayList<>();
        try {
            final String query = "SELECT * FROM \"PUBLIC\".\"users\"";
            final PreparedStatement statement = databaseController.getConnection().prepareStatement(query);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final User user = new User(resultSet.getInt("user_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("email"),
                        resultSet.getString("cellphone"), resultSet.getBoolean("marketing"));
                users.add(user);
            }
            resultSet.close();
            statement.close();
        } catch (final Exception e) {
            // logging
        }
        return users;
    }

    public TableView<User> getUserTable() {
        final TableView<User> userTable = models.getUserTableModel();
        final List<User> userData = getUsers();
        final ObservableList<User> userList = FXCollections.observableArrayList();
        userList.setAll(userData);
        for (final User user : userList) {
            userTable.getItems().add(user);
        }
        return userTable;
    }

    public void createUser(final String firstName, final String lastName, final String email, final String cellphone,
            final boolean isSelected) {
        final User user = new User(firstName, lastName, email, cellphone, isSelected);
        databaseController.insertUser(createUserQuery(user));
    }

    private boolean checkUserExists(final String email) {
        try {
            final String query = "SELECT * FROM \"PUBLIC\".\"users\" WHERE  \"email\" = ?";
            final PreparedStatement statement = databaseController.getConnection().prepareStatement(query);
            statement.setString(1, email);
            try (ResultSet userResultSet = statement.executeQuery()) {
                if (userResultSet.next() == false) {
                    return false;
                }
            }
        } catch (final Exception exception) {
            LOGGER.error("Exception during user existence check: " + exception.getMessage());
        }
        return true;
    }

    private String createUserQuery(final User user) {
        // Get the data from the user object
        final String firstName = user.getFirstName();
        final String lastName = user.getLastName();
        final String email = user.getEmail();
        final String cellphone = user.getCellphone();
        final int marketing = user.getMarketing();

        if (checkUserExists(email) == true) {
            LOGGER.info("User with email `{}` already exists.", email);
            return null;
        }

        return "INSERT INTO \"PUBLIC\".\"users\" (\"first_name\", \"last_name\", \"email\", \"cellphone\", \"marketing\" ) VALUES ('"
                + firstName + "', '" + lastName + "', '" + email + "', '" + cellphone + "', '" + marketing + "');";
    }

}
