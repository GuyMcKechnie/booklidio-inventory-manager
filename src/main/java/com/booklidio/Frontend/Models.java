package com.booklidio.Frontend;

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
    public static void setSellersTableModel(TableView<Seller> sellersTableView,
            List<Seller> sellerData) {
        ObservableList<Seller> sellerList = FXCollections.observableArrayList();
        sellerList.setAll(sellerData);

        // Add the columns
        TableColumn<Seller, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        TableColumn<Seller, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        sellersTableView.getColumns().clear();
        sellersTableView.getColumns().addAll(idColumn, firstNameColumn);
        // Add the rows from seller list
        Seller seller = new Seller(1, "John");
        sellersTableView.getItems().add(seller);
    }
}
