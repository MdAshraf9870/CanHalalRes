package com.e.canhalalres.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.android.volley.VolleyError;
import com.e.canhalalres.Activity.Dashboard.Dashboard;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.e.canhalalres.Utils.CustomProgressDialog;
import com.e.canhalalres.Utils.CustomVolley;

import java.util.HashMap;

public class Login extends AppCompatActivity {
    TextView txtSignup,txtforgetpassword;
    EditText editPassword,editEmail;
    LinearLayout linear_login;
    ImageView passwordHide,passwordShow;
    Dialog pd;
    public static final String TAG = Login.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_login);

        pd = CustomProgressDialog.getInstance().customProgressDialog(Login.this);
        findView();
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });
        txtforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,ForgetPassword.class);
                startActivity(intent);
            }
        });
        passwordShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordHide.setVisibility(View.VISIBLE);
                passwordShow.setVisibility(View.GONE);
                editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
        passwordHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordShow.setVisibility(View.VISIBLE);
                passwordHide.setVisibility(View.GONE);
                editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        });
        linear_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Login.this, Dashboard.class);
//                startActivity(intent);
                if (validation()){
                          getLogin();
                }
            }
        });
    }

    private void getLogin() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Email",editEmail.getText().toString().trim());
        hashMap.put("Password",editPassword.getText().toString().trim());
       if (pd != null) {
            pd.show();
        }
        CustomVolley.getInstance().postVolley(Login.this, Url.login, hashMap, TAG, new CustomVolley.IRequestCallbacks() {
            @Override
            public void onStringResponse(String response) {
                if (response!=null && !response.isEmpty()){
                    if (pd != null && pd.isShowing()) {
                        pd.dismiss();
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                   }

                }else{
                    pd.dismiss();
                    Toast.makeText(Login.this, "response is empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                pd.dismiss();
                Toast.makeText(Login.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validation() {
        if (editEmail.getText().toString().trim().isEmpty()){
            editEmail.requestFocus();
            editEmail.setError("Please Enter Email");
            return false;
        }else if (editPassword.getText().toString().trim().isEmpty()){
            editPassword.requestFocus();
            editPassword.setError("Please Enter Password");
            return false;
        }

        return true;
    }


    private void findView() {
        txtSignup = (TextView) findViewById(R.id.txtSignup);
        txtforgetpassword = (TextView)findViewById(R.id.txtforgetpassword);
        linear_login = (LinearLayout) findViewById(R.id.linear_login);
        passwordHide = (ImageView) findViewById(R.id.passwordHide);
        passwordShow = (ImageView) findViewById(R.id.passwordShow);
        editPassword =(EditText) findViewById(R.id.editPassword);
        editEmail = (EditText) findViewById(R.id.editEmail);


    }

    public void goDashbord(View view) {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
}