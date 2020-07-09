package com.bloombrain.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bloombrain.R;

public class LoginActivity extends AppCompatActivity {
    TextView btnForgotPassword;
    Button btnLogin;
    TextView btnSignUp;


    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_login);
        this.btnLogin = (Button)findViewById(R.id.btn_login);
        this.btnForgotPassword = (TextView)findViewById(R.id.btn_forgot_password);
        this.btnSignUp = (TextView)findViewById(R.id.btn_sign_up);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                LoginActivity.this.startActivity(new Intent((Context)LoginActivity.this, HomeActivity.class));
            }
        });
        this.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {}
        });
        this.btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                LoginActivity.this.startActivity(new Intent((Context)LoginActivity.this, RegistrationActivity.class));
            }
        });
    }

}

