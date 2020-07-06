package com.vr.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vr.mainactivity.R;

public class MainActivity extends AppCompatActivity {

    ProgressBar splashProgress;
    int SPLASH_TIME = 3000; //This is 3 seconds
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

        //This is additional feature, used to run a progress bar
        splashProgress = findViewById(R.id.splashProgress);
        playProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(mySuperIntent);
                finish();

            }
        }, SPLASH_TIME);
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(5000)
                .start();
    }
}