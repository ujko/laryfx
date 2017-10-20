package lary.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import lary.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static String FXML_THEME = "/fxml/ConnectionSettings.fxml";
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private MenuButtonsController menuButtonsController;

    public void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_THEME));
        loader.setResources(Utils.getResourceBundle());
        logger.debug("Loaded Theme: " + FXML_THEME);
        Pane pane = loader.load();
        mainBorderPane.setCenter(pane);
        logger.debug("mainBorderPane set center pane");
        menuButtonsController.setMainController(this);
    }
}
