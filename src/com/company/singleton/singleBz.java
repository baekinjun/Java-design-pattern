package com.company.singleton;

public class singleBz {

    private SocketClient socketClient;

    public singleBz() {
        this.socketClient = SocketClient.getInstance();

    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
