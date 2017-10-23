package lary.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class Dialogs {
    public static void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Utils.getResourceBundle().getString("msg.errtitle"));
        alert.setHeaderText(Utils.getResourceBundle().getString("msg.error"));
        alert.getDialogPane().setContent(new TextArea(errorMessage));
        alert.showAndWait();
    }
}
