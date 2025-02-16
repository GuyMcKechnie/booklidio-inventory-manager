package com.booklidio.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.Database.DatabaseController;
import com.booklidio.Utilities.Validator;

public class UserController {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Validator VALIDATOR = new Validator();

    public static void addUser(String firstName, String lastName, String email, String cellphone, boolean marketing) {

        if (!VALIDATOR.validateInput(firstName, true, false, false) ||
                !VALIDATOR.validateInput(lastName, true, false, false) ||
                !VALIDATOR.validateInput(email, false, true, false) ||
                !VALIDATOR.validateInput(cellphone, false, false, true)) {
            return;
        }

        if (checkUserExists(email) == true) {
            LOGGER.info("User with email `{}` already exists.", email);
            return;
        }

        try {
            int marketingInt = getMarketingInt(marketing);
            String query = "INSERT INTO \"PUBLIC\".\"users\" (\"first_name\", \"last_name\", \"email\", \"cellphone\", \"marketing\" ) VALUES ('"
                    + firstName + "', '" + lastName + "', '" + email + "', '" + cellphone + "', '"
                    + marketingInt + "');";
            PreparedStatement statement = DatabaseController.connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            LOGGER.error("Exception during user addition: " + exception.getMessage());
        }
        LOGGER.info("Added user with name '{} {}'", firstName, lastName);
    }

    private static boolean checkUserExists(String email) {
        try {
            String query = "SELECT * FROM \"PUBLIC\".\"users\" WHERE  \"email\" = ?";
            PreparedStatement statement = DatabaseController.connection.prepareStatement(query);
            statement.setString(1, email);
            try (ResultSet userResultSet = statement.executeQuery()) {
                if (userResultSet.next() == false) {
                    return false;
                }
            }
        } catch (Exception exception) {
            LOGGER.error("Exception during user existence check: " + exception.getMessage());
        }
        return true;
    }

    private static int getMarketingInt(boolean isSelected) {
        if (isSelected == false) {
            return 0;
        } else if (isSelected == true) {
            return 1;
        } else {
            return -1;
        }
    }
}
