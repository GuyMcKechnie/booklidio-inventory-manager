package com.booklidio.Frontend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.booklidio.Utilities.Authenticator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FrontendController {

    @FXML
    private HBox viewOrders;
    @FXML
    private HBox newOrder;
    @FXML
    private MenuItem navbar_viewOrders;
    @FXML
    private MenuItem navbar_newOrder;

    @FXML
    private void changeDashboard(ActionEvent event) {
        List<HBox> dashboards = Arrays.asList(newOrder, viewOrders);
        List<MenuItem> dashboardLabels = Arrays.asList(navbar_newOrder, navbar_viewOrders);
        for (int i = 0; i < dashboards.size(); i++) {
            if (dashboardLabels.get(i) == event.getSource()) {
                dashboards.get(i).setVisible(true);
                dashboardLabels.get(i).getStyleClass().add("accent");
            } else {
                dashboards.get(i).setVisible(false);
                dashboardLabels.get(i).getStyleClass().remove("accent");
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
    private TextField emailField;
    @FXML
    private TextField passwordField;

    @FXML
    private void handle_loginButtonSubmit(ActionEvent event) {
        boolean isAuthorised = Authenticator.authenticateUser(emailField.getText(), passwordField.getText());
        if (isAuthorised) {

        }
    }
}
