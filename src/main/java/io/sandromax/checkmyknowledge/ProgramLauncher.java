package io.sandromax.checkmyknowledge;

import io.sandromax.checkmyknowledge.services.TestConductor;
import io.sandromax.checkmyknowledge.view.controller.ResultSceneController;
import io.sandromax.checkmyknowledge.view.controller.StartSceneController;
import io.sandromax.checkmyknowledge.view.controller.TestSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramLauncher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent start = FXMLLoader.load(getClass().getResource("/TestScene.fxml"));
//        Parent testScene = FXMLLoader.load(getClass().getResource("/TestScene.fxml"));
//        Parent resultScene = FXMLLoader.load(getClass().getResource("/ResultScene.fxml"));

//        FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/StartScene.fxml"));
//        Parent startScenePane = startSceneLoader.load();
//
//        FXMLLoader testSceneLoader = new FXMLLoader(getClass().getResource("/TestScene.fxml"));
//        Parent testScenePane = testSceneLoader.load();
//
//        FXMLLoader resultSceneLoader = new FXMLLoader(getClass().getResource("/ResultScene.fxml"));
//        Parent resultScenePane = resultSceneLoader.load();
//
//        Scene startScene = new Scene(startScenePane, 800, 600);
//        Scene testScene = new Scene(testScenePane, 800, 600);
//        Scene resultScene = new Scene(resultScenePane, 800, 600);
//
//        //        Scene firstScene = new Scene(startScenePane, 300, 275);
//
//        StartSceneController startSceneController = (StartSceneController) startSceneLoader.getController();
//        TestSceneController testSceneController = (TestSceneController) testSceneLoader.getController();
//        ResultSceneController resultSceneController = (ResultSceneController) resultSceneLoader.getController();
//
//        TestConductor testConductor = new TestConductor();
//
//        startSceneController.setTestConductor(testConductor);
//        startSceneController.setTestScene(testScene);
//        startSceneController.setResultScene(resultScene);
//
//        testSceneController.setTestConductor(testConductor);
//        testSceneController.setStartScene(startScene);
//        testSceneController.setResultScene(resultScene);
//
//        resultSceneController.setTestConductor(testConductor);
//        resultSceneController.setStarttScene(startScene);
//        resultSceneController.setTestScene(testScene);

        primaryStage.setTitle("Check My Knowledge");
        primaryStage.setScene(new Scene(start, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
