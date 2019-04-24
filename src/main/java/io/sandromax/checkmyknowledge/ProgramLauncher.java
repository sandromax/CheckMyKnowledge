package io.sandromax.checkmyknowledge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramLauncher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent start = FXMLLoader.load(getClass().getResource("/TestScene.fxml"));

        primaryStage.setTitle("Check My Knowledge");
        primaryStage.setScene(new Scene(start, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
