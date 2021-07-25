package com.e.canhalalres.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.canhalalres.R;

public class ForgetPassword extends AppCompatActivity {
    LinearLayout linear_send;
    TextView txtbackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        findView();
        linear_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassword.this,OTPActivity.class);
                startActivity(intent);
            }
        });
        txtbackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassword.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void findView() {
        linear_send = (LinearLayout) findViewById(R.id.linear_send);
        txtbackLogin = (TextView) findViewById(R.id.txtbackLogin);
    }
}