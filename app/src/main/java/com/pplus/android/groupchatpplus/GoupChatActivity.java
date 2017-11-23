package com.pplus.android.groupchatpplus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class GoupChatActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout grChat1, grChat2;
    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goup_chat);
        initMapped();//Anh xa doi tuong
    }

    private void initMapped() {
        grChat1 = (RelativeLayout) findViewById(R.id.grChat_1);
        grChat2 = (RelativeLayout) findViewById(R.id.grChat_2);
        edtName = (EditText) findViewById(R.id.edt_name);
        //Set onClick
        grChat1.setOnClickListener(this);
        grChat2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //truyen du lieu sang chatactivity
        Bundle bundle = new Bundle();
        String userName = edtName.getText().toString().trim();
        //truyen user name
        bundle.putString("name", userName);

        Intent intent = new Intent(GoupChatActivity.this, Chat_Activity.class);


        switch (v.getId()) {
            case R.id.grChat_1:
                Log.d("socket", "set room 1" );
                bundle.putString("room", "1");

                break;
            case R.id.grChat_2:
                Log.d("socket", "set room 2" );
                bundle.putString("room", "2");
        }

        //chuyen phong
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
