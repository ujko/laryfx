package lary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lary.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class Main extends Application {
    private final String FXML_MAIN_FILE = "/fxml/Main.fxml";
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_MAIN_FILE));
        loader.setResources(Utils.getResourceBundle());
        logger.debug("Loaded Theme: " + FXML_MAIN_FILE);
        BorderPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Utils.getResourceBundle().getString("application.title"));
        primaryStage.show();
    }
}
