package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.domain.Result;
import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultSceneController {
    private TestConductor testConductor;
    private Scene starttScene, testScene;

    @FXML
    private Label lblResults;

    @FXML
    private TableView<Result> tvResults;

    @FXML
    private TableColumn<Result, String> colQuestion, colYourAnswer, colRightAnswer;

    public void setTestConductor(TestConductor conductor) {
        testConductor = conductor;
    }

    public void setStarttScene(Scene starttScene) {
        this.starttScene = starttScene;
    }

    public void setTestScene(Scene testScene) {
        this.testScene = testScene;
    }
}
