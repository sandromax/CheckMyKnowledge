package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TestSceneController {
    private TestConductor testConductor;
    private Scene startScene, resultScene;

    @FXML
    Label lblProgress, lblQuestion, lblFirstVariant, lblSecondVariant, lblThirdVariant, lblFourthVariant;

    @FXML
    CheckBox cbFirstVariant, cbSecondVariant, cbThirdVariant, cbFourthVariant;

    @FXML
    Button btnEnd, btnNext;

    public void setTestConductor(TestConductor conductor) {
        testConductor = conductor;
    }

    public void setStartScene(Scene startScene) {
        this.startScene = startScene;
    }

    public void setResultScene(Scene resultScene) {
        this.resultScene = resultScene;
    }

    @FXML
    private void endTest(ActionEvent event) {

    }
}
