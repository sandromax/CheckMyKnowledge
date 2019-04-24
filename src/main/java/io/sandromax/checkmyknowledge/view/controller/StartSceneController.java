package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartSceneController {
    private TestConductor testConductor;

    @FXML
    private Label lblPath, lblErrors;

    @FXML
    private Button btnChoose, btnStart;

    @FXML
    public void initialize() {
        lblPath.setText("/Users/sandro/Documents/projects/_PORTFOLIO/KarinaTest/CheckMyKnowledge/src/main/resources/acouch.txt");
    }

    @FXML
    private void chooseAnother(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
//        fileChooser.setTitle("Open Document");//Заголовок диалога
//        FileChooser.ExtensionFilter extFilter =
//                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
//        fileChooser.getExtensionFilters().add(extFilter);
//        File file = fileChooser.showOpenDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
//        if (file != null) {
//            //Open
//            System.out.println("Процесс открытия файла");
//        }
    }

    @FXML
    private void goToTests(ActionEvent event) {
        if(lblPath.getText().equals("")) {
            lblErrors.setText("Ошибка! Выберите файл");
            return;
        }

        try {
            testConductor = new TestConductor(lblPath.getText());
        } catch (IOException e) {
            e.printStackTrace();
            lblErrors.setText("Ошибка загрузки файла с тестами");
        }

        try {
            FXMLLoader testPageLoader = new FXMLLoader(getClass().getResource("/TestScene.fxml"));
            Parent testScenePane = testPageLoader.load();
            Scene testScene = new Scene(testScenePane, 800, 600);

            TestSceneController testSceneController = (TestSceneController) testPageLoader.getController();
            testSceneController.setTestConductor(testConductor);

            Stage stage = (Stage) btnStart.getScene().getWindow();
            testSceneController.setTestConductor(testConductor);

            stage.setScene(testScene);
        }catch (IOException io){
            io.printStackTrace();
            lblErrors.setText("Ошибка загрузки следующего вида");
        }
    }

}
