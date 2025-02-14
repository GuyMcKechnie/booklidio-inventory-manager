package com.booklidio.Frontend;

import java.io.IOException;
import java.util.HashMap;

import com.booklidio.Main;
import com.booklidio.Utilities.Authenticator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FrontendController {

    @FXML
    private HBox viewOrders;
    @FXML
    private HBox newOrder;
    @FXML
    private HBox viewCatalogue;
    @FXML
    private HBox viewInventory;
    @FXML
    private HBox viewSellers;
    @FXML
    private MenuItem navbar_viewOrders;
    @FXML
    private MenuItem navbar_newOrder;
    @FXML
    private MenuItem navbar_viewCatalogue;
    @FXML
    private MenuItem navbar_viewInventory;
    @FXML
    private MenuItem navbar_viewSellers;

    @FXML
    private Group order_editModeGroup = new Group();

    @FXML
    private HBox order_buyerGroup;

    @FXML
    private ToggleButton order_toggleEdit;

    @FXML
    private VBox orderGroup;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    HashMap<MenuItem, HBox> dashboardMap = new HashMap<>();

    @FXML
    VBox catalogueGroup;
    @FXML
    VBox inventoryGroup;
    @FXML
    VBox sellersGroup;

    @FXML
    ToggleButton catalogue_toggleEdit;

    @FXML
    ToggleButton inventory_toggleEdit;
    @FXML
    ToggleButton sellers_toggleEdit;

    @FXML
    public void initialize() {
        initDashboardMap();
    }

    private void initDashboardMap() {
        dashboardMap.put(navbar_viewOrders, viewOrders);
        dashboardMap.put(navbar_newOrder, newOrder);
        dashboardMap.put(navbar_viewCatalogue, viewCatalogue);
        dashboardMap.put(navbar_viewInventory, viewInventory);
        dashboardMap.put(navbar_viewSellers, viewSellers);
    }

    @FXML
    private void changeDashboard(ActionEvent event) {
        for (HashMap.Entry<MenuItem, HBox> entry : dashboardMap.entrySet()) {
            MenuItem key = entry.getKey();
            HBox value = entry.getValue();
            /*
             * Iterate through the dashboard map to toggle the visibility of the
             * corresponding HBox based on the selected MenuItem.
             */
            if (event.getSource().equals(key)) {
                value.setVisible(true);
            } else {
                value.setVisible(false);
            }
        }
    }

    @FXML
    private void handle_loginButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handle_order_toggleEdit() {
        orderGroup.setDisable(!order_toggleEdit.isSelected());
    }

    @FXML
    private void handle_sellers_toggleEdit() {
        sellersGroup.setDisable(!sellers_toggleEdit.isSelected());
    }

    @FXML
    private void handle_catalogue_toggleEdit() {
        catalogueGroup.setDisable(!catalogue_toggleEdit.isSelected());
    }

    @FXML
    private void handle_inventory_toggleEdit() {
        inventoryGroup.setDisable(!inventory_toggleEdit.isSelected());
    }

    @FXML
    private void catalogue_edit_save() {

    }

    @FXML
    private void catalogue_edit_discard() {

    }

    @FXML
    private void refresh() throws Exception {
        Main main = new Main();
        main.start(Main.primaryStage);
    }

    @FXML
    private void handle_loginButtonSubmit(ActionEvent event) {
        boolean isAuthorised = Authenticator.authenticateUser(emailField.getText(), passwordField.getText());
        if (isAuthorised) {

        }
    }
}
