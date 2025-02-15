package com.booklidio;

import com.booklidio.Frontend.FrontendController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage = null;
    public static Scene dashboardScene = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            Main.primaryStage = primaryStage;

            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Dashboard.fxml"));
            Parent root = loader.load();

            // Create the scene
            Main.dashboardScene = new Scene(root);
            FrontendController.setStackPane(dashboardScene.getRoot().getChildrenUnmodifiable().get(1));
            Main.dashboardScene.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());

            // Set the scene on the stage
            primaryStage.setScene(Main.dashboardScene);
            primaryStage.setTitle("Booklidio");
            primaryStage.setResizable(false);
            primaryStage.setHeight(852);
            primaryStage.setWidth(1280);

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