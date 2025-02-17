package com.booklidio;

import com.booklidio.Database.DatabaseController;
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

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        try {

            // Connect to the database
            DatabaseController.setConnection();

            Main.primaryStage = primaryStage;

            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Container.fxml"));
            final Parent root = loader.load();

            // Create the scene
            Main.dashboardScene = new Scene(root);
            FrontendController.setStackPane(dashboardScene.getRoot().getChildrenUnmodifiable().get(1));
            Application.setUserAgentStylesheet(getClass().getResource("/Styles/Style.css").toExternalForm());

            // Make the dashboard the first element
            loader = new FXMLLoader(getClass().getResource("/UI/Dashboard.fxml"));
            final Parent dashboard = loader.load();
            FrontendController.container.getChildren().add(dashboard);

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
            final Image icon = new Image(getClass().getResourceAsStream("/Images/Icon.svg"));
            primaryStage.getIcons().add(icon);

            // Init stage
            primaryStage.show();

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}