package lary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lary.manager.ConnectionParamManager;
import lary.model.ConnectionParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

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

    private BorderPane borderPane;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ConnectionParamManager connectionParamManager = new ConnectionParamManager();

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
        connectionParamManager.addConnectionParam(connectionParam);
        setConnectionsInListView();
    }

    @FXML
    public void setDataInTextFields() {
        ConnectionParam connectionParam = (ConnectionParam) connectionsListView.getSelectionModel().getSelectedItem();
        if (connectionParam != null) {
            logger.debug(connectionParam.toString());
            this.connName.setText(connectionParam.getConnName());
            this.connUser.setText(connectionParam.getConnUser());
            this.connPassword.setText(connectionParam.getConnPass());
            this.connServer.setText(connectionParam.getConnServer());
            this.connPort.setText(connectionParam.getConnPort());
            this.connService.setText(connectionParam.getConnService());
        }
    }

    public void deleteConnectionSetting(ActionEvent actionEvent) {
        ConnectionParam connectionParam = (ConnectionParam) connectionsListView.getSelectionModel().getSelectedItem();
        connectionParamManager.deleteConnectionParam(connectionParam);
        setConnectionsInListView();
    }

    public void connect(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LogSearchController.fxml"));
        AnchorPane pane = loader.load();
        borderPane.setCenter(pane);
    }

    public void setParentPanel(BorderPane pane) {
        this.borderPane = pane;
    }

    private void setConnectionsInListView() {
        List<ConnectionParam> connectionParams = connectionParamManager.getConnectionParams();
        logger.debug(connectionParams.toString());
        ObservableList<ConnectionParam> paramObservableList = FXCollections.observableList(connectionParams);
        connectionsListView.setItems(paramObservableList);
    }


}
