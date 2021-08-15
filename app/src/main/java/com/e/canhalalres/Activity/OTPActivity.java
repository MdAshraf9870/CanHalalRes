package com.e.canhalalres.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.e.canhalalres.Activity.RestaurantDetail.RestaurantDetail;
import com.e.canhalalres.R;

public class OTPActivity extends AppCompatActivity {
    EditText editOTP1,editOTP2,editOTP3,editOTP4;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        findView();
        editOTP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editOTP1.getText().toString().trim().length() == 1){
                    editOTP2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editOTP2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editOTP2.getText().toString().trim().length()==1){
                    editOTP3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editOTP3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editOTP3.getText().toString().trim().length()==1){
                    editOTP4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this, RestaurantDetail.class);
                startActivity(intent);
            }
        });
    }

    private void findView() {
        editOTP1 = (EditText) findViewById(R.id.editotp1);
        editOTP2 = (EditText) findViewById(R.id.editotp2);
        editOTP3 = (EditText) findViewById(R.id.editotp3);
        editOTP4 = (EditText) findViewById(R.id.editotp4);
        btn_submit = (Button) findViewById(R.id.btn_submit);
    }
}