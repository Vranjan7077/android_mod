package com.bloombrain.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bloombrain.R;
import com.bloombrain.adapter.ClassAdapter;
import com.bloombrain.app.ClassItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class Learn extends Fragment {

    private ClassAdapter adapter;

    private List<ClassItem> classItemList;

    private int dpToPx(int paramInt) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(1, paramInt, resources.getDisplayMetrics()));
    }

    private void prepareClasses() {
        ClassItem classItem = new ClassItem("Geometry", "Today, 10 AM", "Introduction To Trigonometry", "");
        this.classItemList.add(classItem);
        classItem = new ClassItem("Science", "Today, 11 AM", "Chemical Reactions & Equations - II", "");
        this.classItemList.add(classItem);
        classItem = new ClassItem("Algebra", "10 Jun, 10 AM", "Point", "");
        this.classItemList.add(classItem);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.fragment_learn, paramViewGroup, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv_class);
        this.classItemList = new ArrayList<ClassItem>();
        this.adapter = new ClassAdapter(getContext(), this.classItemList);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)getActivity()));
        recyclerView.addItemDecoration(new SpacingItemDecoration(dpToPx(10)));
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
        recyclerView.setAdapter((RecyclerView.Adapter)this.adapter);
        prepareClasses();
        return view;
    }

    public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spacing;

        public SpacingItemDecoration(int param1Int) {
            this.spacing = param1Int;
        }

        @Override
        public void getItemOffsets(@NotNull Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.left = this.spacing;
            param1Rect.right = this.spacing;
            param1Rect.top = this.spacing;
            param1Rect.bottom = this.spacing;
        }
    }
}