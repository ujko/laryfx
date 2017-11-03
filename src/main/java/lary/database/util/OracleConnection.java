package lary.database.util;

import lary.params.model.ConnectionParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static OracleConnection instance = null;
    private Connection connection;

    private OracleConnection() {
    }

    public static OracleConnection getInstance() {
        if (instance == null) {
            instance = new OracleConnection();
        }
        return instance;
    }

    public void setConnection(ConnectionParam connectionParam) throws IllegalArgumentException{
        String connectionString = "jdbc:oracle:thin:@" + connectionParam.getConnServer() + ":" + connectionParam.getConnPort() + ":" + connectionParam.getConnService();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(connectionString, connectionParam.getConnUser(), connectionParam.getConnPass());
            logger.info("Connected to Oracle");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if(!connection.isClosed()) {
                connection.close();
                logger.info("Disconnected from Oracle");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
