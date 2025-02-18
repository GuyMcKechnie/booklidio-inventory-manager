package com.booklidio.Frontend;

import java.util.Arrays;

import com.booklidio.User.User;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Models {
    public TableView<User> getUserTableModel() {
        TableView<User> userTable = new TableView<>();

        userTable.getColumns().clear();
        TableColumn<User, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        TableColumn<User, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<User, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<User, String> cellphoneColumn = new TableColumn<>("Cellphone");
        cellphoneColumn.setCellValueFactory(new PropertyValueFactory<>("cellphone"));
        TableColumn<User, Integer> marketingColumn = new TableColumn<>("Marketing");
        marketingColumn.setCellValueFactory(new PropertyValueFactory<>("marketing"));
        userTable.getColumns().addAll(Arrays.asList(idColumn, firstNameColumn, lastNameColumn, emailColumn,
                cellphoneColumn, marketingColumn));

        return userTable;
    }
}
