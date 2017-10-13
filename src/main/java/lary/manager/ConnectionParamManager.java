package lary.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import lary.model.ConnectionParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ConnectionParamManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String JSON_FILE = "connparam.json";

    public List<ConnectionParam> getConnectionParams() {
        ObjectMapper mapper = new ObjectMapper();
        List<ConnectionParam> connectionParams = new ArrayList<>();
        try {
            connectionParams = Arrays.asList(mapper.readValue(new File(JSON_FILE),ConnectionParam[].class));
            logger.debug(connectionParams.toString());
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return connectionParams;
    }

    public void addConnectionParam(ConnectionParam connectionParam) {
        logger.debug(connectionParam.toString());
        List<ConnectionParam> connectionParams = getConnectionParams();
        Set<ConnectionParam> cp = new TreeSet<>();
        cp.addAll(connectionParams);
//        connectionParams = new ArrayList<>(connectionParams);
//        connectionParams.add(connectionParam);
//        Collections.sort(connectionParams);
        cp.add(connectionParam);
        logger.debug(connectionParams.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_FILE), cp);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
