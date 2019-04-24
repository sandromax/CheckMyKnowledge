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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
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

        lblResults.setText("Результаты: правильно " + testConductor.getRightIssues() + " из " + testConductor.getTotalIssues());

        question.setCellFactory(column -> {
            return new TableCell<Result, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);

                        Result auxResult = getTableView().getItems().get(getIndex());

                        if (auxResult.getRightAnswer().equals(auxResult.getYourAnswer())) {
                            setTextFill(Color.rgb(7, 173, 50));
                        } else {
                            if(getTableView().getSelectionModel().getSelectedItems().contains(auxResult))
                                setTextFill(Color.WHITE);
                            else
                                setTextFill(Color.rgb(253, 71, 63));
                        }
                    }
                }
            };
        });

        yourAnswer.setCellFactory(column -> {
            return new TableCell<Result, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        Result auxResult = getTableView().getItems().get(getIndex());

                        if (auxResult.getRightAnswer().equals(auxResult.getYourAnswer())) {
                            setTextFill(Color.rgb(7, 173, 50));
                        } else {
                            if(getTableView().getSelectionModel().getSelectedItems().contains(auxResult))
                                setTextFill(Color.WHITE);
                            else
                                setTextFill(Color.rgb(253, 71, 63));
                        }
                    }
                }
            };
        });

        rightAnswer.setCellFactory(column -> {
            return new TableCell<Result, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty); //This is mandatory

                    if (item == null || empty) { //If the cell is empty
                        setText(null);
                        setStyle("");
                    } else { //If the cell is not empty

                        setText(item); //Put the String data in the cell

                        //We get here all the info of the Person of this row
                        Result auxResult = getTableView().getItems().get(getIndex());

                        // Style all persons wich name is "Edgard"
                        if (auxResult.getRightAnswer().equals(auxResult.getYourAnswer())) {
                            setTextFill(Color.rgb(7, 173, 50)); //The text in red
//                            setStyle("-fx-background-color: #f5f5f5"); //The background of the cell in yellow
//                            setTextFill(Color.color(7, 173, 50)); //The text in red
//                            setStyle("-fx-background-color: #f5f5f5");
                        } else {
                            //Here I see if the row of this cell is selected or not
                            if(getTableView().getSelectionModel().getSelectedItems().contains(auxResult))
                                setTextFill(Color.WHITE);
                            else
                                setTextFill(Color.rgb(253, 71, 63));
                        }
                    }
                }
            };
        });

        tvResults.setItems(results);

    }

    @FXML
    private void testAgain(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TestScene.fxml"));
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
