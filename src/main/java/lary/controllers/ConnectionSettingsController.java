package lary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import lary.manager.ConnectionParamManager;
import lary.model.ConnectionParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ConnectionSettingsController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
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

    @FXML
    public void initialize() {
        setConnectionsInListView();
    }

    @FXML
    public void saveConnectionSettings(ActionEvent actionEvent) {
        ConnectionParam connectionParam = new ConnectionParam.ConnectionParamBuilder()
                .connName(connName.getText())
                .connUser(connUser.getText())
                .connPass(connPassword.getText())
                .connServer(connServer.getText())
                .connPort(connPort.getText())
                .connService(connService.getText())
                .build();
        logger.info(connectionParam.toString());
        //TODO: Create inject
        ConnectionParamManager connectionParamManager = new ConnectionParamManager();
        connectionParamManager.addConnectionParam(connectionParam);
        setConnectionsInListView();
    }
    private void setConnectionsInListView() {
        ConnectionParamManager connectionParamManager = new ConnectionParamManager();
        List<ConnectionParam> connectionParams = connectionParamManager.getConnectionParams();
        logger.debug(connectionParams.toString());
        ObservableList<ConnectionParam> paramObservableList = FXCollections.observableList(connectionParams);
        connectionsListView.setItems(paramObservableList);
    }
}
