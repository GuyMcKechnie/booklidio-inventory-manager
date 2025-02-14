package com.booklidio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booklidio.Database.DatabaseController;
import com.booklidio.Frontend.FrontendController;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Dashboard.fxml"));
            Parent root = loader.load();

            // Create the scene
            Scene dashboardScene = new Scene(root);

            // Set the scene on the stage
            primaryStage.setScene(dashboardScene);
            primaryStage.setTitle("Booklidio");
            primaryStage.setResizable(false);
            primaryStage.setHeight(800);
            primaryStage.setWidth(1280);
            dashboardScene.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
            dashboardScene.getStylesheets().add(getClass().getResource("/Styles/primer-dark.css").toExternalForm());

            // Handle the close request
            primaryStage.setOnCloseRequest(event -> {
                System.exit(0);
            });

            // Add the icon
            Image icon = new Image(getClass().getResourceAsStream("/Images/Icon.svg"));
            primaryStage.getIcons().add(icon);

            // Init stage
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}