package com.pplus.android.groupchatpplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Chat_Activity extends AppCompatActivity {

    TextView txtUserName;
    ListView lvMess;
    EditText edtMess;
    ImageButton ibtnSend;

    ArrayList<String> listMessages = new ArrayList<>();
    ArrayAdapter adapter;

    private Socket mSocket = new ChatApplication().getSocket();

    String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_);
        initControls();
        initDisplay();
        initEvents();
    }

    private void initEvents() {

        mSocket.on("new mess"+room, onNewMessage);

        ibtnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("socket", "send");
                sendMessenge();
            }

        });
    }

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String message;
                    try {
                        message = data.getString("text");
                    } catch (JSONException e) {
                        return;
                    }

                    // add the message to view
                    addMessage(message);
                    Log.d("socket", "have mess");
                }
            });
        }
    };

    private void sendMessenge() {
        String mess = edtMess.getText().toString().trim();
        mSocket.emit("new messege"+room, mess);
        Log.d("socket", "sended " + mess);
        edtMess.setText("");
    }

    private void addMessage(String message) {
        listMessages.add(message);
        adapter.notifyDataSetChanged();
    }

    private void initDisplay() {

    }

    private void initControls() {
        txtUserName = (TextView) findViewById(R.id.textViewUser);
        lvMess = (ListView) findViewById(R.id.listViewChat);
        edtMess = (EditText) findViewById(R.id.editText_inputMessenge);
        ibtnSend = (ImageButton) findViewById(R.id.imageButton_send);

        mSocket.connect();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMessages);
        lvMess.setAdapter(adapter);

        Intent intent = getIntent();
        txtUserName.setText(intent.getStringExtra("name"));
        room = intent.getStringExtra("room");
        Log.d("socket", "room " + room);

        //register
        mSocket.emit("register", txtUserName.getText().toString().trim());
    }

}
