package lary.model;

public class ConnectionParam implements Comparable {
    private String connName;
    private String connUser;
    private String connPass;
    private String connServer;
    private String connPort;
    private String connService;

    private ConnectionParam() {
    }

    private ConnectionParam(ConnectionParamBuilder cpb) {
        this.connName = cpb.connName;
        this.connUser = cpb.connUser;
        this.connPass = cpb.connPass;
        this.connServer = cpb.connServer;
        this.connPort = cpb.connPort;
        this.connService = cpb.connService;
    }

    public String getConnName() {
        return connName;
    }

    public String getConnUser() {
        return connUser;
    }

    public String getConnPass() {
        return connPass;
    }

    public String getConnServer() {
        return connServer;
    }

    public String getConnPort() {
        return connPort;
    }

    public String getConnService() {
        return connService;
    }

    @Override
    public String toString() {
        return connName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionParam that = (ConnectionParam) o;

        return connName.equals(that.connName);
    }

    @Override
    public int hashCode() {
        return connName.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        ConnectionParam cp = (ConnectionParam) o;
        return this.connName.compareTo(cp.getConnName());
    }

    public static class ConnectionParamBuilder {
        private String connName;
        private String connUser;
        private String connPass;
        private String connServer;
        private String connPort;
        private String connService;

        public ConnectionParamBuilder connName(String connName) {
            if(connName==null || "".equals(connName)) {
                throw new IllegalArgumentException("Name is required field");
            }
            this.connName = connName;
            return this;
        }

        public ConnectionParamBuilder connUser(String connUser) {
            this.connUser = connUser;
            return this;
        }

        public ConnectionParamBuilder connPass(String connPass) {
            this.connPass = connPass;
            return this;
        }

        public ConnectionParamBuilder connServer(String connServer) {
            this.connServer = connServer;
            return this;
        }

        public ConnectionParamBuilder connPort(String connPort) {
            this.connPort = connPort;
            return this;
        }

        public ConnectionParamBuilder connService(String connService) {
            this.connService = connService;
            return this;
        }

        public ConnectionParam build() {
            return new ConnectionParam(this);
        }
    }
}
