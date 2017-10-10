package lary.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnectionSettingsController {
    @FXML
    public ListView connectionsListView;
    @FXML
    public TextField connName;
    @FXML
    public TextField connUser;
    @FXML
    public PasswordField connPassword;
    @FXML
    public TextField connServer;
    @FXML
    public TextField connPort;
    @FXML
    public TextField connServis;
}
