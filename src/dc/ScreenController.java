/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mian Hamza Saqib
 */
public class ScreenController {
    String stageTitle;
    String fxmlFileName;
    Stage stage;

    public ScreenController() {
        stage = null;
    }

    public ScreenController(String fxmlFileName, String stageTitle) {
        this.fxmlFileName = fxmlFileName;
        this.stageTitle = stageTitle;
    }

    public void start() {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.println("GUI.ScreenController.start() " + ex.getMessage());
        }
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage = new Stage();
        stage.setTitle(stageTitle);
        //stage.hide(); //optional
        stage.setScene(scene);
        stage.show();

//        } else if (stage.isShowing()) {
//            stage.toFront();
//        } else {
//            stage.show();
//        }
    }

    public void setFxmlFileName(String fxmlFileName) {
        this.fxmlFileName = fxmlFileName;
    }

    public String getFxmlFileName() {
        return fxmlFileName;
    }

    public void setStageTitle(String stageTitle) {
        this.stageTitle = stageTitle;
    }

    public String getStageTitle() {
        return stageTitle;
    }
}
