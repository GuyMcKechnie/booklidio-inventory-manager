package com.booklidio.Frontend;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import com.booklidio.User.Seller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class Models {
    public static TableView<Seller> getSellersTableModel() {
        // Create the table
        TableView<Seller> sellerTable = new TableView<>();

        // Add the columns and set the data
        sellerTable.getColumns().clear();
        TableColumn<Seller, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        TableColumn<Seller, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        sellerTable.getColumns().addAll(Arrays.asList(idColumn, firstNameColumn));

        // Return table
        return sellerTable;
    }
}
