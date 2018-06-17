package com.mb.socketiodemo;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class DriverApplication extends Application {
    public Socket mSocket;

    {
        try {
            mSocket = IO.socket(Constants.SOCKET_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    // Get socket object.
    public Socket getSocket() {
        return mSocket;
    }
}
