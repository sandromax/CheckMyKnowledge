package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.domain.Result;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultSceneController {
    @FXML
    private Label lblResults;

    @FXML
    private TableView<Result> tvResults;

    @FXML
    private TableColumn<Result, String> colQuestion, colYourAnswer, colRightAnswer;
}
