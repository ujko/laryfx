package lary.controllers;

public class MenuButtonsController {
    private static final String CONNECTION_SETTINGS_FXML = "/fxml/ConnectionSettings.fxml";
    private static final String LOG_SEARCH_FXML = "/fxml/LogSearch.fxml";
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void connectionProperties() {
        mainController.setFxmlTheme(CONNECTION_SETTINGS_FXML);
    }

    public void logPreview() {
        mainController.setFxmlTheme(LOG_SEARCH_FXML);
    }
}
