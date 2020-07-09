package com.bloombrain.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bloombrain.R;

public class RegistrationActivity extends AppCompatActivity {
    TextView btnLogin;

    Button btnRegister;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_registration);
        this.btnRegister = (Button)findViewById(R.id.btn_sign_up);
        TextView textView = (TextView)findViewById(R.id.btn_login);
        this.btnLogin = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                RegistrationActivity.this.startActivity(new Intent((Context)RegistrationActivity.this, LoginActivity.class));
            }
        });
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                RegistrationActivity.this.startActivity(new Intent((Context)RegistrationActivity.this, LoginActivity.class));
            }
        });
    }
}