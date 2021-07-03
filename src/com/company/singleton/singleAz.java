package com.company.singleton;

public class singleAz {

    private SocketClient socketClient;

    public singleAz() {
        this.socketClient = SocketClient.getInstance();

    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
