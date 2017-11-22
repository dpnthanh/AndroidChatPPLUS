package com.pplus.android.groupchatpplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUserName, edtPassword;
    Button btnLogin;
    TextView txtForgotPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initControls();
        initDisplay();
        initEvents();
    }

    private void initEvents() {
        btnLogin.setOnClickListener(this);
        txtForgotPass.setOnClickListener(this);

    }

    private void initDisplay() {

    }

    private void initControls() {
        edtUserName = (EditText) findViewById(R.id.editText_userName_loginActivity);
        edtPassword = (EditText) findViewById(R.id.editText_password_loginActivity);
        btnLogin = (Button) findViewById(R.id.button_Login_loginActivity);
        txtForgotPass = (Button) findViewById(R.id.button_Login_loginActivity);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_Login_loginActivity:

                login();

                break;
            case R.id.textView_f_loginActivityorgotPass:

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void login() {

    }
}
