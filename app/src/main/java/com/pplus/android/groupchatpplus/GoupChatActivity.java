package com.pplus.android.groupchatpplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GoupChatActivity extends AppCompatActivity implements View.OnClickListener{
    TextView grChat1, grChat2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goup_chat);
        initMapped();//Anh xa doi tuong
    }

    private void initMapped() {
        grChat1 = (TextView) findViewById(R.id.txt_name_item_group_1);
        grChat2 = (TextView) findViewById(R.id.txt_name_item_group_2);
        //Set onClick
        grChat1.setOnClickListener(this);
        grChat2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.grChat_1:
                try{
                    Intent intent = new Intent(GoupChatActivity.this,Chat_Activity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.grChat_2:
                try{
                    Toast.makeText(this, "Clicked GR chat 2", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
