package lary.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import lary.model.ConnectionParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionSettingsController {
    @FXML
    public ToggleGroup dictionary;
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
    public TextField connService;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @FXML
    public void saveConnectionSettings(ActionEvent actionEvent) {
        ConnectionParam connectionParam = new ConnectionParam.ConnectionParamBuilder()
                .connName(connName.getText())
                .connUser(connUser.getText())
                .connPass(connPassword.getText())
                .connPort(connPort.getText())
                .connService(connService.getText())
                .build();
        logger.info(connectionParam.toString());
    }
}
