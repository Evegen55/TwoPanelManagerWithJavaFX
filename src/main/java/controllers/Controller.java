package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author (created on 6/23/2017).
 */
public class Controller {

    @FXML
    private Tab myTabWithFiles;

    public void method() {
        myTabWithFiles.setContent(new Rectangle(50, 50, Color.CHOCOLATE));

    }

}
