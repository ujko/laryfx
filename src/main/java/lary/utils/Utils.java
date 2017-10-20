package lary.utils;

import java.util.ResourceBundle;

public class Utils {
    public static final String FXML_MAIN = "/fxml/Main.fxml";

/*    public static Pane setCurrentPane() {
//        FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXML_MAIN));
    }*/

    @org.jetbrains.annotations.NotNull
    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundles.messages");
    }
}
