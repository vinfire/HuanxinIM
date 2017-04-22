package com.example.gtr.huanxinim.controller.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gtr.huanxinim.R;

public class LoginActivity extends Activity implements View.OnClickListener{

    private EditText et_login_name;
    private EditText et_login_password;
    private Button btn_login_regist;
    private Button btn_login_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        btn_login_regist = (Button) findViewById(R.id.btn_login_regist);
        btn_login_login = (Button) findViewById(R.id.btn_login_login);



    }

    @Override
    public void onClick(View v) {

    }
}
