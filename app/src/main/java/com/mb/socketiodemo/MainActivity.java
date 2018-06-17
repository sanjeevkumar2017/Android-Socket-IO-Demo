package com.mb.socketiodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    private Socket mSocket;
    private Boolean isConnected = true;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = (TextView) findViewById(R.id.tv_message);


        try {
            mSocket = IO.socket("http://service.thesamaritan.in");
            Log.d(TAG, "mSocket :: " + mSocket.connect().id());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
//        mSocket.on(Socket.EVENT_CONNECT, onConnect);
//        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
//        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
//        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
//        mSocket.on("newBooking", onNewBooking);
//        mSocket.connect();
//        try {
//            JSONObject jsonObject = new JSONObject(mSocket.toString());
//            Log.d(TAG, "mSocket :: " + jsonObject.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        mSocket.off(Socket.EVENT_CONNECT, onConnect);
//        mSocket.off(Socket.EVENT_DISCONNECT, onDisconnect);
//        mSocket.off(Socket.EVENT_CONNECT_ERROR, onConnectError);
    }

    /**
     * After Socket connection we will get a socket id that has to be stored and send back to the server along with user object.
     **/
    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.d(TAG, "Socket connected....");

//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        final JSONObject data = (JSONObject) args[0];
//                        Log.d(TAG, data.toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            for (Object data : args) {
//                Log.d(TAG, "DATA :: " + data.toString());
//            }
        }
    };


}
