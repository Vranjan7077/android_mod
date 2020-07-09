package com.bloombrain.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bloombrain.Activity.PlanDetailActivity;
import com.bloombrain.R;
import com.bloombrain.app.PlanItem;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {
  private Context mContext;
  
  private List<PlanItem> planItemList;
  
  public PlanAdapter(Context paramContext, List<PlanItem> paramList) {
    this.mContext = paramContext;
    this.planItemList = paramList;
  }
  
  private void launchPlanActivity(Context paramContext, PlanItem paramPlanItem) {
    Intent intent = new Intent(paramContext, PlanDetailActivity.class);
    intent.putExtra("PlanName", paramPlanItem.getPlanName());
    intent.putExtra("PlanPrice", paramPlanItem.getPlanPrice());
    intent.putStringArrayListExtra("PlanDetails", paramPlanItem.getPlanDetails());
    paramContext.startActivity(intent);
  }
  
  public int getItemCount() {
    return this.planItemList.size();
  }
  
  public void onBindViewHolder(MyViewHolder paramMyViewHolder, final int position) {
    final PlanItem planItem = this.planItemList.get(position);
    paramMyViewHolder.tvPlanName.setText(planItem.getPlanName());
    paramMyViewHolder.tvPlanPrice.setText(planItem.getPlanPrice());
    paramMyViewHolder.tvDetails.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Context context = PlanAdapter.this.mContext;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(position);
            stringBuilder.append(" Pressed");
            Toast.makeText(context, stringBuilder.toString(), 1).show();
            PlanAdapter planAdapter = PlanAdapter.this;
            planAdapter.launchPlanActivity(planAdapter.mContext, planItem);
          }
        });
  }
  
  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.plans_card, paramViewGroup, false));
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView tvDetails;
    
    public TextView tvPlanName;
    
    public TextView tvPlanPrice;
    
    public MyViewHolder(View param1View) {
      super(param1View);
      this.tvPlanName = (TextView)param1View.findViewById(R.id.plan_name);
      this.tvPlanPrice = (TextView)param1View.findViewById(R.id.plan_price);
      this.tvDetails = (TextView)param1View.findViewById(R.id.plan_details);
    }
  }
}
