package com.padcmyanmar.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by einandartun on 11/5/17.
 */

public class LoginActivity extends AppCompatActivity {


    private static final String CORRECT_EMAIL = "abc@gmail.com"; //constant attribute define
    private static final String CORRECT_PASSWORD = "Abcdefg"; //constant attribute define

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassword;
    private TextView btnNewSellerRegister;

    public  static Intent newIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forget_password);
        btnNewSellerRegister = findViewById(R.id.btn_newseller_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String passowrd = etPassword.getText().toString();
                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or phone cannot be empty.");
                    return;
                }
                if(TextUtils.isEmpty(passowrd)){
                    etPassword.setError("Password cannot be empty.");
                    return;
                }

                if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                        && TextUtils.equals(passowrd, CORRECT_PASSWORD)){
                    //Toast.makeText(getApplicationContext(),  "Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                } else {
                    Snackbar.make(view, "Fail", Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
                }
                //Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "\"Forgot Password\" is coming soon", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnNewSellerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Registration Screen is coming soon", Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }
}
