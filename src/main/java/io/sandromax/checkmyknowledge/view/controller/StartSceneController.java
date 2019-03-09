package io.sandromax.checkmyknowledge.view.controller;

import io.sandromax.checkmyknowledge.services.TestConductor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartSceneController {
    private TestConductor testConductor;
    private Scene testScene, resultScene;

    @FXML
    private Label lblPath;

    @FXML
    private Button btnChoose, btnStart;

    @FXML
    public void initialize() {
        lblPath.setText("acouch_ua.txt");
    }

    public void setTestConductor(TestConductor conductor) {
        testConductor = conductor;
    }

    public void setTestScene(Scene testScene) {
        this.testScene = testScene;
    }

    public void setResultScene(Scene resultScene) {
        this.resultScene = resultScene;
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
    private void startTest(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TestScene.fxml"));
            Stage stage = (Stage) btnStart.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

//    @FXML
//    public void findLogMouseEntered(MouseEvent event)
//    {
//        btnChoose.setTooltip(new Tooltip("Search field value in to entire log"));
//    }

}
