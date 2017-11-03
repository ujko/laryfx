package lary.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;

public class Dialogs {
    public static void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Utils.getResourceBundle().getString("msg.errtitle"));
        alert.setHeaderText(Utils.getResourceBundle().getString("msg.error"));
        alert.getDialogPane().setContent(new TextArea(errorMessage));
        alert.showAndWait();
    }

    public static Optional<ButtonType> showConfirmDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        return alert.showAndWait();
    }
}
