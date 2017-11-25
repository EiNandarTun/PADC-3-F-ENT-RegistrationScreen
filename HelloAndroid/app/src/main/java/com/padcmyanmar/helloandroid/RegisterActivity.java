package com.padcmyanmar.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by einandartun on 11/13/17.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private Button btnRegister;
    private TextView btnToLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        etAddress = findViewById(R.id.et_address);
        btnRegister = findViewById(R.id.btn_register);
        btnToLogin = findViewById(R.id.btn_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                String address = etAddress.getText().toString();


                if(TextUtils.isEmpty(name)){
                    etName.setError("Name cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    etPhone.setError("Phone cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    etConfirmPassword.setError("Confirm password cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(address)){
                    etAddress.setError("Address cannot be empty");
                    return;
                }
                if(!password.equals(confirmPassword)){
                    etConfirmPassword.setError("Password and Confirm Password must be same.");
                    return;
                }


                    Intent intent = LoginActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }

        });

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
            });
    }
}
