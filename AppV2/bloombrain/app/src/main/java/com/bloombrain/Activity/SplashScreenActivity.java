package com.bloombrain.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bloombrain.R;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView logo_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.logo = (ImageView)findViewById(R.id.logo);
        this.logo_text = (TextView)findViewById(R.id.logo_text);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom);
        this.logo.startAnimation(animation1);
        this.logo_text.startAnimation(animation2);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent((Context)SplashScreenActivity.this, WelcomeActivity.class);
//                intent.setFlags(67108864);
                SplashScreenActivity.this.startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        },3000);
    }


}
