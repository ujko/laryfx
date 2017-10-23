package lary.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ResourceBundle;

public class Utils {
    private static final String FXML_MAIN = "/fxml/Main.fxml";
    private static Logger logger = LoggerFactory.getLogger(Utils.class.getName());

    public static Pane setCurrentPane(String theme) {
        FXMLLoader loader = new FXMLLoader(Utils.class.getResource(theme));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundles.messages");
    }
}
