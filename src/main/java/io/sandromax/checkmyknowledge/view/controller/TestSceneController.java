package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.domain.Issue;
import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSceneController {
    private TestConductor testConductor;
    private Scene startScene, resultScene;
    private Issue currentIssue;

    @FXML
    Label lblProgress, lblQuestion, lblFirstVariant, lblSecondVariant, lblThirdVariant, lblFourthVariant, lblMessage;

    @FXML
    CheckBox cbFirstVariant, cbSecondVariant, cbThirdVariant, cbFourthVariant;

    @FXML
    Button btnBegin, btnEnd, btnNext;

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
    public void initialize() {
        lblProgress.setVisible(false);
        lblQuestion.setVisible(false);
        lblFirstVariant.setVisible(false);
        lblSecondVariant.setVisible(false);
        lblThirdVariant.setVisible(false);
        lblFourthVariant.setVisible(false);
        lblMessage.setVisible(false);
        cbFirstVariant.setVisible(false);
        cbSecondVariant.setVisible(false);
        cbThirdVariant.setVisible(false);
        cbFourthVariant.setVisible(false);
        btnEnd.setVisible(false);
        btnNext.setVisible(false);
    }

    @FXML
    public void beginTest(ActionEvent event) {
        lblProgress.setText(testConductor.getRightIssues() + "/" + testConductor.getTotalIssues());

        currentIssue = testConductor.getNewIssue();

        lblQuestion.setText(currentIssue.getQuestion());

        List<String> variants = new LinkedList<>(currentIssue.getVariantAnswers()).stream().sorted().collect(Collectors.toList());

        lblFirstVariant.setText(variants.get(0));
        lblSecondVariant.setText(variants.get(1));
        lblThirdVariant.setText(variants.get(2));
        lblFourthVariant.setText(variants.get(3));

        lblProgress.setVisible(true);
        lblQuestion.setVisible(true);
        lblFirstVariant.setVisible(true);
        lblSecondVariant.setVisible(true);
        lblThirdVariant.setVisible(true);
        lblFourthVariant.setVisible(true);
        lblMessage.setVisible(true);

        cbFirstVariant.setVisible(true);
        cbSecondVariant.setVisible(true);
        cbThirdVariant.setVisible(true);
        cbFourthVariant.setVisible(true);

        btnEnd.setVisible(true);
        btnNext.setVisible(true);
        btnBegin.setVisible(false);
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        int numberOfSelected = howManyCheckboxSelected(cbFirstVariant, cbSecondVariant, cbThirdVariant, cbFourthVariant);
        if(numberOfSelected == 0) {
            lblMessage.setText("Не вибран вариант ответа");
            return;
        }

        CheckBox selected = getSelectedCheckBox(cbFirstVariant, cbSecondVariant, cbThirdVariant, cbFourthVariant);
        Label selectedLabel = (Label) selected.getParent().getChildrenUnmodifiable().get(1);
        String answer = selectedLabel.getText();

        if(answer.equals(currentIssue.getRightAnswer())) {
            testConductor.answerIsRight();
        } else {
            testConductor.answerIsWrong();
        }

        testConductor.saveIssueDone(currentIssue, answer);

        currentIssue = testConductor.getNewIssue();

        refreshView();
    }

    @FXML
    private void endTest(ActionEvent event) {
        try {
            System.out.println("results: " + testConductor.getTestResults().getResults().size());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ResultScene.fxml"));
            Stage stage = (Stage) btnEnd.getScene().getWindow();
            Scene scene = new Scene(loader.load());
//            stage.setTitle("Результаты");
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    private int howManyCheckboxSelected(CheckBox ... checkBoxes) {
        int times = 0;

        for(CheckBox checkBox : checkBoxes) {
            if(checkBox.isSelected()) {
                times++;
            }
        }

        return times;
    }

    private CheckBox getSelectedCheckBox(CheckBox ... checkBoxes) {
        CheckBox selectedCheckbox = null;

        for(CheckBox checkBox : checkBoxes) {
            if(checkBox.isSelected()) {
                selectedCheckbox = checkBox;
            }
        }

        return selectedCheckbox;
    }

    private void refreshView() {
        lblProgress.setText(testConductor.getRightIssues() + "/" + testConductor.getTotalIssues());

        lblQuestion.setText(currentIssue.getQuestion());

        List<String> variants = new LinkedList<>(currentIssue.getVariantAnswers()).stream().sorted().collect(Collectors.toList());

        lblFirstVariant.setText(variants.get(0));
        lblSecondVariant.setText(variants.get(1));
        lblThirdVariant.setText(variants.get(2));
        lblFourthVariant.setText(variants.get(3));
    }

    @FXML
    private void select(ActionEvent event) {
        cbFirstVariant.setSelected(false);
        cbSecondVariant.setSelected(false);
        cbThirdVariant.setSelected(false);
        cbFourthVariant.setSelected(false);

        Node source = (Node) event.getSource();
        CheckBox checkBox = (CheckBox) source.getParent().getChildrenUnmodifiable().get(0);
        checkBox.setSelected(true);
    }

}
