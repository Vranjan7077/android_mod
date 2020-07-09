package com.bloombrain.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bloombrain.Fragments.Learn;
import com.bloombrain.Fragments.Profile;
import com.bloombrain.Fragments.Tests;

import com.bloombrain.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem param1MenuItem) {
           Tests tests;
           Profile profile;
            switch (param1MenuItem.getItemId()) {
                default:
                    return false;
                case R.id.navigation_test:
                   tests = new Tests();
                    HomeActivity.this.loadFragment((Fragment)tests);
                    return true;
                case R.id.navigation_profile:
                   profile = new Profile();
                    HomeActivity.this.loadFragment((Fragment)profile);
                    return true;
                case R.id.navigation_learn:
                    break;
            }

            Learn learn = new Learn();
            HomeActivity.this.loadFragment((Fragment)learn);
            return true;
        }
    };

    public void loadFragment(Fragment paramFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.frame_container, paramFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_home);
        ((BottomNavigationView)findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        loadFragment((Fragment)new Learn());
    }

}