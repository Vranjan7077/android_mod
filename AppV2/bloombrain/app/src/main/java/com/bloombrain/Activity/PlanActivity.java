package com.bloombrain.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;

import com.bloombrain.R;
import com.bloombrain.adapter.PlanAdapter;
import com.bloombrain.app.PlanItem;

import java.util.ArrayList;
import java.util.List;

public class PlanActivity extends AppCompatActivity {

    PlanAdapter adapter;

    private ImageButton btnBack;

    private List<PlanItem> planList;

    RecyclerView recyclerView;

    private int dpToPx(int paramInt) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(1, paramInt, resources.getDisplayMetrics()));
    }

    private void preparePlans() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("50 Live Interactive Class");
        arrayList.add("Doubt Clearing Session");
        arrayList.add("Unlimited Practice Tests");
        PlanItem planItem2 = new PlanItem("Basic Plan", "INR 20, 000/-", arrayList);
        this.planList.add(planItem2);
        arrayList.clear();
        arrayList.add("Monthly Report Cards to parents");
        arrayList.add("Counselling & Mentorship Sessions");
        PlanItem planItem1 = new PlanItem("Premium Plan", "INR 35, 000/-", arrayList);
        this.planList.add(planItem1);
        this.adapter.notifyDataSetChanged();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_plan);
        this.recyclerView = (RecyclerView)findViewById(R.id.rv_plans);
        this.btnBack = (ImageButton)findViewById(R.id.btn_plan_activity_back);
        this.planList = new ArrayList<PlanItem>();
        this.adapter = new PlanAdapter((Context)this, this.planList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.recyclerView.addItemDecoration(new SpacingItemDecoration(dpToPx(10)));
        this.recyclerView.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
        this.recyclerView.setAdapter((RecyclerView.Adapter)this.adapter);
        preparePlans();
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                PlanActivity.this.finish();
            }
        });
    }

    public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spacing;

        public SpacingItemDecoration(int param1Int) {
            this.spacing = param1Int;
        }

        public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.left = this.spacing;
            param1Rect.right = this.spacing;
            param1Rect.top = this.spacing;
            param1Rect.bottom = this.spacing;
        }
    }
}