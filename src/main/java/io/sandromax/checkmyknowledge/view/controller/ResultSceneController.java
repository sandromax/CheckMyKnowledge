package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.domain.Result;
import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultSceneController {
    private TestConductor testConductor;
    private ObservableList<Result> results = FXCollections.observableArrayList();

    @FXML
    private Label lblResults;

    @FXML
    private TableView<Result> tvResults;

    @FXML
    private TableColumn<Result, String> question, yourAnswer, rightAnswer;

    @FXML
    private Button btnTestAgain;

    public void setTestConductor(TestConductor conductor) {
        testConductor = conductor;
        results = testConductor.getTestResults();

        question.setCellValueFactory(new PropertyValueFactory<>("question"));
        yourAnswer.setCellValueFactory(new PropertyValueFactory<>("yourAnswer"));
        rightAnswer.setCellValueFactory(new PropertyValueFactory<>("rightAnswer"));

        tvResults.setItems(results);

    }

    @FXML
    private void testAgain(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScene.fxml"));
            Stage stage = (Stage) btnTestAgain.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
