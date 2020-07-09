package com.bloombrain.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.bloombrain.R;
import com.bloombrain.adapter.TestAdapter;
import com.bloombrain.app.TestItem;

import java.util.ArrayList;
import java.util.List;


public class Tests extends Fragment {

    private TestAdapter adapter;

    private RecyclerView recyclerView;

    private List<TestItem> testItemList;

    private int dpToPx() {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(1, 10, resources.getDisplayMetrics()));
    }

    private void prepareTests() {
        TestItem testItem = new TestItem("Test 1", "Maths", 10, 30, "MCQ", 0);
        this.testItemList.add(testItem);
        testItem = new TestItem("Test 2", "Science", 20, 30, "Written", 0);
        this.testItemList.add(testItem);
        testItem = new TestItem("Test 3", "History", 30, 30, "MCQ", 0);
        this.testItemList.add(testItem);
        this.adapter.notifyDataSetChanged();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.fragment_tests, paramViewGroup, false);
        final String[] subjects = new String[5];
        final String[] arrayOfString = new String[5];
        arrayOfString[0] = "Geometry";
        arrayOfString[1] = "Algebra";
        arrayOfString[2] = "Science";
        arrayOfString[3] = "English";
        arrayOfString[4] = "All Subjects";
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv_test);
        this.testItemList = new ArrayList<TestItem>();
        this.adapter = new TestAdapter(getContext(), this.testItemList);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)getActivity()));
        recyclerView.addItemDecoration(new SpacingItemDecoration(dpToPx()));
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
        recyclerView.setAdapter((RecyclerView.Adapter)this.adapter);
        prepareTests();
        Spinner spinner = (Spinner)view.findViewById(R.id.sp_subjects);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                Toast.makeText((Context)Tests.this.getActivity(), arrayOfString[param1Int], Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> param1AdapterView) {}
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context)getActivity(),android.R.layout.simple_spinner_item, (Object[])arrayOfString);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter)arrayAdapter);
        return view;
    }

    public static class SpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spacing;

        public SpacingItemDecoration(int param1Int) {
            this.spacing = param1Int;
        }

        public void getItemOffsets(@NonNull Rect param1Rect, @NonNull View param1View, @NonNull RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.left = this.spacing;
            param1Rect.right = this.spacing;
            param1Rect.top = this.spacing;
            param1Rect.bottom = this.spacing;
        }
    }
}