package com.pplus.android.groupchatpplus;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

class ChatApplication {
    private Socket mSocket;
    {
        try{
            mSocket = IO.socket("http://10.200.202.239:3000");
//            mSocket = IO.socket("https://pplus-chat-group.herokuapp.com:80");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket(){
        return mSocket;
    }
}
