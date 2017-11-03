package lary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import lary.database.util.OracleConnection;
import lary.params.manager.ConnectionParamManager;
import lary.params.model.ConnectionParam;
import lary.utils.Dialogs;
import lary.utils.Utils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class ConnectionSettingsController {


    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ConnectionParamManager connectionParamManager = new ConnectionParamManager();
    @FXML
    private ToggleButton connectionButton;
    @FXML
    private ToggleGroup dictionary;
    @FXML
    private ListView connectionsListView;
    @FXML
    private TextField connName;
    @FXML
    private TextField connUser;
    @FXML
    private PasswordField connPassword;
    @FXML
    private TextField connServer;
    @FXML
    private TextField connPort;
    @FXML
    private TextField connService;
    @FXML
    private ListView listViewLogs;

    @FXML
    public void initialize() {
        setConnectionsInListView();
    }

    @FXML
    public void saveConnectionSettings() {
        try {
            ConnectionParam connectionParam = getConnectionParam();
            connectionParamManager.addConnectionParam(connectionParam);
            setConnectionsInListView();
        } catch (IllegalArgumentException e) {
            logger.info(e.getMessage());
        }
    }

    @NotNull
    private ConnectionParam getConnectionParam() {
        ConnectionParam connectionParam = new ConnectionParam.ConnectionParamBuilder()
                .connName(connName.getText())
                .connUser(connUser.getText())
                .connPass(connPassword.getText())
                .connServer(connServer.getText())
                .connPort(connPort.getText())
                .connService(connService.getText())
                .build();
        logger.info(connectionParam.toString());
        return connectionParam;
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

    public void deleteConnectionSetting() {
        ConnectionParam connectionParam = (ConnectionParam) connectionsListView.getSelectionModel().getSelectedItem();
        connectionParamManager.deleteConnectionParam(connectionParam);
        setConnectionsInListView();
    }

    public void addLogsToListView() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Utils.getResourceBundle().getString("msg.addLogFiles"));
        List<File> listLogs = fileChooser.showOpenMultipleDialog(null);
        if (listLogs != null) {
            logger.debug("Adding " + listLogs + " to listLogs");
            listViewLogs.getItems().addAll(listLogs);
        }
    }

    public void deleteLogsFromListView() {
        listViewLogs.getItems().remove(listViewLogs.getSelectionModel().getSelectedIndex());
        logger.debug(listViewLogs.getItems().toString());
    }

    private void setConnectionsInListView() {
        List<ConnectionParam> connectionParams = connectionParamManager.getConnectionParams();
        logger.debug(connectionParams.toString());
        ObservableList<ConnectionParam> paramObservableList = FXCollections.observableList(connectionParams);
        connectionsListView.setItems(paramObservableList);
    }

    @FXML
    public void connect() {
        OracleConnection connection = OracleConnection.getInstance();
        if (connectionButton.isSelected()) {
            ConnectionParam connectionParam = null;
            try {
                connectionParam = getConnectionParam();
                connection.setConnection(connectionParam);
                connectionButton.setText(Utils.getResourceBundle().getString("buttons.disconnect"));
            } catch (IllegalArgumentException e){
                connectionButton.setSelected(false);
                Dialogs.showErrorDialog(e.getMessage());
                logger.error(e.getMessage());
            }
        } else {
            logger.info("Btn connection is off");
            connection.closeConnection();
            connectionButton.setText(Utils.getResourceBundle().getString("buttons.connect"));
        }
    }


}
