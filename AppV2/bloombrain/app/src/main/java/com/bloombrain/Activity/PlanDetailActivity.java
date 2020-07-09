package com.bloombrain.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bloombrain.R;

public class PlanDetailActivity extends AppCompatActivity {

    ImageButton btnPlanDetailsBack;

    CardView cardFeatureDetails;

    TextView tvPlanName;

    TextView tvPlanPrice;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_plan_detail);
        this.tvPlanName = (TextView)findViewById(R.id.details_plan_name);
        this.tvPlanPrice = (TextView)findViewById(R.id.details_plan_price);
        this.cardFeatureDetails = (CardView)findViewById(R.id.feature_details_card);
        ImageButton imageButton = (ImageButton)findViewById(R.id.btn_plan_details_back);
        this.btnPlanDetailsBack = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                PlanDetailActivity.this.finish();
            }
        });
        Intent intent = getIntent();
        this.tvPlanName.setText(intent.getStringExtra("PlanName"));
        this.tvPlanPrice.setText(intent.getStringExtra("PlanPrice"));
    }
}