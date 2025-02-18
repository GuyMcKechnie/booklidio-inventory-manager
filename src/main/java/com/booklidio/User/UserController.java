package com.booklidio.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.Database.DatabaseController;
import com.booklidio.Frontend.Models;
import com.booklidio.Utilities.Validator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TableView;

public class UserController {
    private static final Logger LOGGER = LogManager.getLogger();
    DatabaseController databaseController = new DatabaseController();

    public static List<Seller> getSellers() {
        List<Seller> sellerList = new ArrayList<>();
        try {
            String query = "SELECT * FROM \"PUBLIC\".\"users\"";
            PreparedStatement statement = DatabaseController.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seller data = new Seller(resultSet.getInt("user_id"), resultSet.getString("first_name"));
                sellerList.add(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sellerList;
    }

    public static TableView<Seller> getSellerTable() {
        TableView<Seller> sellerTable = Models.getSellersTableModel();
        List<Seller> sellerData = getSellers();
        ObservableList<Seller> sellerList = FXCollections.observableArrayList();
        sellerList.setAll(sellerData);
        for (Seller seller : sellerList) {
            sellerTable.getItems().add(seller);
        }
        return sellerTable;
    }

    private static boolean checkUserExists(String email) {
        try {
            String query = "SELECT * FROM \"PUBLIC\".\"users\" WHERE  \"email\" = ?";
            PreparedStatement statement = DatabaseController.getConnection().prepareStatement(query);
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

    public void createUser(String firstName, String lastName, String email, String cellphone, boolean isSelected) {
        User user = new User(firstName, lastName, email, cellphone, isSelected);
        databaseController.insertUser(createUserQuery(user));
    }

    private String createUserQuery(User user) {
        // Get the data from the user object
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String cellphone = user.getCellphone();
        int marketing = user.getMarketing();

        if (checkUserExists(email) == true) {
            LOGGER.info("User with email `{}` already exists.", email);
            return null;
        }

        return "INSERT INTO \"PUBLIC\".\"users\" (\"first_name\", \"last_name\", \"email\", \"cellphone\", \"marketing\" ) VALUES ('"
                + firstName + "', '" + lastName + "', '" + email + "', '" + cellphone + "', '" + marketing + "');";
    }

}
