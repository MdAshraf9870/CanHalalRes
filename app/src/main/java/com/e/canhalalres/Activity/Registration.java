package com.e.canhalalres.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.e.canhalalres.Utils.CustomVolley;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Registration extends AppCompatActivity {
    TextView txtSignIn;
    EditText editFullName,editEmail,editMobile,editPassword,editConfirmPassword;
    LinearLayout linear_create;
    ImageView passwordHide,passwordShow,confirmpassswordhide,confirmpassswordshow;
    public static final String TAG = Registration.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        findView();
        passwordShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordHide.setVisibility(View.GONE);
                passwordShow.setVisibility(View.VISIBLE);
                editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
        passwordHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordShow.setVisibility(View.GONE);
                passwordHide.setVisibility(View.VISIBLE);
                editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        });
        confirmpassswordshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmpassswordhide.setVisibility(View.GONE);
                confirmpassswordshow.setVisibility(View.VISIBLE);
                editConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
        confirmpassswordhide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmpassswordshow.setVisibility(View.GONE);
                confirmpassswordhide.setVisibility(View.VISIBLE);
                editConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        });
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });
        linear_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validation()){
                    getCreateUser();
                }else {
                    Toast.makeText(Registration.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void getCreateUser() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Username",editFullName.getText().toString().trim());
        hashMap.put("Email",editEmail.getText().toString().trim());
        hashMap.put("Mobile",editMobile.getText().toString().trim());
        hashMap.put("Password",editPassword.getText().toString().trim());
        CustomVolley.getInstance().postVolley(Registration.this, "http://ccepmt.com/api/User/register", hashMap, TAG, new CustomVolley.IRequestCallbacks() {
            @Override
            public void onStringResponse(String response) {
               if (response!=null && !response.isEmpty()){
                   Toast.makeText(Registration.this, "Success", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(Registration.this, "Failed", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Registration.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
                Log.d(TAG,volleyError.toString());

            }
        });

    }

    private boolean validation() {
        if (editFullName.getText().toString().trim().isEmpty()){
            editFullName.requestFocus();
            editFullName.setError("Please Enter FullName");
            return false;
        }else if (editEmail.getText().toString().trim().isEmpty()){
            editEmail.setError("Please Enter Email");
            editEmail.requestFocus();
            return false;
        }else if (editMobile.getText().toString().trim().isEmpty()){
            editMobile.setError("Please Enter Mobile No");
            editMobile.requestFocus();
            return false;
        }else if (editPassword.getText().toString().trim().isEmpty()){
            editPassword.setError("Please Enter Password");
            editPassword.requestFocus();
            return false;
        }else if (editConfirmPassword.getText().toString().trim().isEmpty()){
            editConfirmPassword.setError("Please Enter Confirm Password");
            editConfirmPassword.requestFocus();
            return false;
        }/*else if(editConfirmPassword.getText().toString().trim() != editPassword.getText().toString().trim()){
            editConfirmPassword.setError("Password not matched");
            editConfirmPassword.requestFocus();
            return false;
        }*/
        return true;
    }


    private void findView() {
        editFullName = (EditText) findViewById(R.id.editFullName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editMobile = (EditText) findViewById(R.id.editMobile);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        linear_create = (LinearLayout) findViewById(R.id.linear_create);
        passwordHide = (ImageView) findViewById(R.id.passwordHide);
        passwordShow = (ImageView) findViewById(R.id.passwordShow);
        confirmpassswordshow = (ImageView) findViewById(R.id.confirmpassswordshow);
        confirmpassswordhide = (ImageView) findViewById(R.id.confirmpassswordhide);
        txtSignIn = (TextView) findViewById(R.id.txtSignIn);

    }


    private void  CreateAccount(){
       try {
           StringRequest request = new StringRequest(Request.Method.POST, "http://ccepmt.com/api/User/register",
                   response -> {
                       if (response!=null){
                           Toast.makeText(Registration.this, ""+ response, Toast.LENGTH_SHORT).show();
                       }

                   }, (VolleyError volleyError) -> {
               Toast.makeText(Registration.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
               Log.d(TAG,volleyError.toString());
           }

           ) {
               @Override
               protected Map<String, String> getParams() {
                   Map<String, String> dataPut = new HashMap<>();
                   dataPut.put("Username","TestUsersss");
                   dataPut.put("Email","nazilnawaz6@gmail.com");
                   dataPut.put("Mobile","827397255");
                   dataPut.put("Password","test1234");
                   return dataPut;
               }
           };
           RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
           requestQueue.add(request);
       }catch (Exception e){

       }
    }
}