package io.sandromax.checkmyknowledge.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class StartSceneController {
    @FXML
    private Label lblPath;

    @FXML
    private Button btnChoose, btnStart;

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

    }

    @FXML
    public void findLogMouseEntered(MouseEvent event)
    {
        btnChoose.setTooltip(new Tooltip("Search field value in to entire log"));
    }

}
