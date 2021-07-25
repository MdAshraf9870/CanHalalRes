package com.e.canhalalres.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.canhalalres.R;

public class ResetPassword extends AppCompatActivity {
    TextView txtbackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        findView();
        txtbackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this,OTPActivity.class);
                startActivity(intent);
            }
        });

    }

    private void findView() {
        txtbackLogin = (TextView) findViewById(R.id.txtbackLogin);
    }
}