package com.bloombrain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.bloombrain.R;
import com.bloombrain.app.ClassItem;
import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder> {
  private List<ClassItem> classItemList;
  
  private Context mContext;
  
  public ClassAdapter(Context paramContext, List<ClassItem> paramList) {
    this.mContext = paramContext;
    this.classItemList = paramList;
  }
  
  private void launchClassActivity(Context paramContext) {}
  
  public int getItemCount() {
    return this.classItemList.size();
  }
  
  public void onBindViewHolder(MyViewHolder paramMyViewHolder, final int position) {
    ClassItem classItem = this.classItemList.get(position);
    paramMyViewHolder.tvTopic.setText(classItem.getTopic());
    paramMyViewHolder.tvSubject.setText(classItem.getSubject());
    paramMyViewHolder.tvTime.setText(classItem.getClassTime());
    paramMyViewHolder.btnCardAction.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Context context = ClassAdapter.this.mContext;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(position);
            stringBuilder.append(" Pressed");
            Toast.makeText(context, stringBuilder.toString(), 1).show();
            ClassAdapter classAdapter = ClassAdapter.this;
            classAdapter.launchClassActivity(classAdapter.mContext);
          }
        });
  }
  
  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.class_card, paramViewGroup, false));
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder {
    public Button btnCardAction;
    
    public TextView tvSubject;
    
    public TextView tvTime;
    
    public TextView tvTopic;
    
    public MyViewHolder(View param1View) {
      super(param1View);
      this.tvTopic = (TextView)param1View.findViewById(R.id.class_topic);
      this.tvSubject = (TextView)param1View.findViewById(R.id.class_subject);
      this.tvTime = (TextView)param1View.findViewById(R.id.class_time);
      this.btnCardAction = (Button)param1View.findViewById(R.id.class_card_action);
    }
  }
}

