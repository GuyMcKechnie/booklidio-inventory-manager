package com.booklidio.Frontend;

import java.io.IOException;
import java.util.HashMap;

import org.controlsfx.control.action.Action;

import com.booklidio.Main;
import com.booklidio.Database.DatabaseController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FrontendController {

    @FXML
    public static StackPane container;

    public static void setStackPane(final Node stackPane) {
        container = (StackPane) stackPane;
    }

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
    private HBox viewDashboard;
    @FXML
    private MenuItem navbar_viewOrders;
    @FXML
    private MenuItem navbar_newOrder;
    @FXML
    private MenuItem navbar_viewCatalogue;
    @FXML
    private Button navbar_viewDashboard;

    @FXML
    private MenuItem navbar_viewInventory;

    @FXML
    private MenuItem navbar_viewSellers;

    @FXML
    private final Group order_editModeGroup = new Group();

    @FXML
    private HBox order_buyerGroup;

    @FXML
    private ToggleButton order_toggleEdit;

    @FXML
    private VBox orderGroup;

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
    private TextField sellerNameField;

    @FXML
    private TextField sellerEmailField;

    // @todo : refactor this method

    @FXML
    private Button addSellerButton;

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField emailField;

    @FXML
    TextField cellphoneField;

    @FXML
    CheckBox marketingConsentBox;

    @FXML
    public void initialize() {
        initDashboardMap();
    }

    public String loadFXML(final MenuItem menuItem) {
        if (menuItem == navbar_viewOrders) {
            return "/UI/ViewOrders.fxml";
        } else if (menuItem == navbar_viewSellers) {
            return "/UI/ViewSellers.fxml";
        } else if (menuItem == navbar_viewCatalogue) {
            return "/UI/ViewCatalogue.fxml";
        } else if (menuItem == navbar_viewInventory) {
            return "/UI/ViewInventory.fxml";
        }
        return null;
    }

    @FXML
    private void changeDashboard(final ActionEvent event) throws Exception {
        final MenuItem selectedItem = (MenuItem) event.getSource();
        final String fxmlFile = loadFXML(selectedItem);

        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            final Parent dashboard = loader.load();
            container.getChildren().clear();
            container.getChildren().add(dashboard);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void initDashboardMap() {
        dashboardMap.put(navbar_viewOrders, viewOrders);
        dashboardMap.put(navbar_newOrder, newOrder);
        dashboardMap.put(navbar_viewCatalogue, viewCatalogue);
        dashboardMap.put(navbar_viewInventory, viewInventory);
        dashboardMap.put(navbar_viewSellers, viewSellers);
    }

    @FXML
    private void handle_loginButton(final ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Login.fxml"));
            final Parent root = loader.load();
            final Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (final IOException e) {
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
        final Main main = new Main();
        main.start(Main.primaryStage);
    }

    @FXML
    private void addSellerPopOver(final ActionEvent event) {
        try {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(Main.primaryStage);
            dialog.setTitle("Add Seller");
            dialog.centerOnScreen();
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/AddSeller.fxml"));
            final Parent content = loader.load();
            final Scene dialogScene = new Scene(content);
            dialog.setScene(dialogScene);
            dialog.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addSeller(final ActionEvent event) {
        DatabaseController.sendTo_addUser(firstNameField.getText(), lastNameField.getText(), emailField.getText(),
                cellphoneField.getText(), marketingConsentBox.isSelected());
    }

    @FXML
    private void handle_viewDashboard(ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Dashboard.fxml"));
            final Parent dashboard = loader.load();
            container.getChildren().clear();
            container.getChildren().add(dashboard);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
