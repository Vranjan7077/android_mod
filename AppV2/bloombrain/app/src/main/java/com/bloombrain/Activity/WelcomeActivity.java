package com.bloombrain.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bloombrain.R;

public class WelcomeActivity extends AppCompatActivity {



        private Button btnNext;

        private Button btnSkip;

        private TextView[] dots;

        private LinearLayout dotsLayout;

        private int[] layouts={R.layout.welcome1, R.layout.welcome2, R.layout.welcome3, R.layout.welcome4};

        private MyViewPagerAdapter myViewPagerAdapter;



        private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

            this.viewPager = (ViewPager)findViewById(R.id.view_pager);
            this.dotsLayout = (LinearLayout)findViewById(R.id.layoutDots);
            this.btnSkip = (Button)findViewById(R.id.btn_skip);
            this.btnNext = (Button)findViewById(R.id.btn_next);

            addBottomDots(0);
            //changeStatusBarColor();

            this.myViewPagerAdapter = new MyViewPagerAdapter();
            this.viewPager.setAdapter(myViewPagerAdapter);
            this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int param1Int) {
                    WelcomeActivity.this.addBottomDots(param1Int);
                    if (param1Int == WelcomeActivity.this.layouts.length - 1) {
                        WelcomeActivity.this.btnNext.setText("Start");
                        WelcomeActivity.this.btnSkip.setVisibility(View.GONE);
                        return;
                    }
                    WelcomeActivity.this.btnNext.setText("Next");
                    WelcomeActivity.this.btnSkip.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }

            });
            this.btnSkip.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    WelcomeActivity.this.launchHomeScreen();
                }
            });
            this.btnNext.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    int i = viewPager.getCurrentItem()+1;
                    if (i < WelcomeActivity.this.layouts.length) {
                        WelcomeActivity.this.viewPager.setCurrentItem(i);
                        return;
                    }
                    WelcomeActivity.this.launchHomeScreen();
                }
            });
        }



    private void addBottomDots(int paramInt) {
        this.dots = new TextView[this.layouts.length];
        int[] arrayOfInt1 = getResources().getIntArray(R.array.array_dot_active);
        int[] arrayOfInt2 = getResources().getIntArray(R.array.array_dot_inactive);
        this.dotsLayout.removeAllViews();
        int i = 0;
        while (true) {
            TextView[] arrayOfTextView = this.dots;
            if (i < arrayOfTextView.length) {
                arrayOfTextView[i] = new TextView((Context)this);
                this.dots[i].setText((CharSequence) Html.fromHtml("&#8226;"));
                this.dots[i].setTextSize(35.0F);
                this.dots[i].setTextColor(arrayOfInt2[paramInt]);
                this.dotsLayout.addView((View)this.dots[i]);
                i++;
                continue;
            }
            if (arrayOfTextView.length > 0)
                arrayOfTextView[paramInt].setTextColor(arrayOfInt1[paramInt]);
            return;
        }
    }


    private int getItem() {
        return this.viewPager.getCurrentItem() ;
    }

    private void launchHomeScreen() {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        finish();
    }

        public class MyViewPagerAdapter extends PagerAdapter

        {


            private LayoutInflater layoutInflater;

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup param1ViewGroup, int param1Int) {
                LayoutInflater layoutInflater = (LayoutInflater)WelcomeActivity.this.getSystemService(WelcomeActivity.LAYOUT_INFLATER_SERVICE);
                this.layoutInflater = layoutInflater;
                View view = layoutInflater.inflate(WelcomeActivity.this.layouts[param1Int], param1ViewGroup, false);
                param1ViewGroup.addView(view);
                return view;
            }





            @Override
            public void destroyItem(@NonNull ViewGroup param1ViewGroup, int param1Int,@NonNull Object param1Object) {
                param1ViewGroup.removeView((View)param1Object);
            }





            @Override
            public int getCount() {
                return WelcomeActivity.this.layouts.length;
            }


            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }
        }
    }