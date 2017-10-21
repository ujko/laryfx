package lary.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import lary.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private MenuButtonsController menuButtonsController;

    public void initialize() {
        menuButtonsController.setMainController(this);
        menuButtonsController.connectionProperties();
    }

    public void setFxmlTheme(String theme) {
        mainBorderPane.setCenter(Utils.setCurrentPane(theme));
    }
}
