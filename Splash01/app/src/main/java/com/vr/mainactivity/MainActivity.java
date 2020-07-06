package com.vr.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView logo_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.logo = (ImageView)findViewById(R.id.logo);
        this.logo_text = (TextView)findViewById(R.id.logo_text);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom);
        this.logo.startAnimation(animation1);
        this.logo_text.startAnimation(animation2);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent((Context)MainActivity.this, HomeActivity.class);
//                intent.setFlags(67108864);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        },3000);
    }
}