package com.bloombrain.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.bloombrain.Activity.QuestionActivity;
import com.bloombrain.R;
import com.bloombrain.app.TestItem;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {
  private Context mContext;
  
  private List<TestItem> testItemList;
  
  public TestAdapter(Context paramContext, List<TestItem> paramList) {
    this.mContext = paramContext;
    this.testItemList = paramList;
  }
  
  private void launchTestActivity(Context paramContext) {
    paramContext.startActivity(new Intent(paramContext, QuestionActivity.class));
  }
  
  public int getItemCount() {
    return this.testItemList.size();
  }
  
  public void onBindViewHolder(MyViewHolder paramMyViewHolder, final int position) {
    TestItem testItem = this.testItemList.get(position);
    paramMyViewHolder.tvName.setText(testItem.getName());
    paramMyViewHolder.tvSubject.setText(testItem.getSubject());
    TextView textView = paramMyViewHolder.tvTime;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(testItem.getTime());
    stringBuilder.append(" mins");
    textView.setText(stringBuilder.toString());
    textView = paramMyViewHolder.tvQuestions;
    stringBuilder = new StringBuilder();
    stringBuilder.append(testItem.getNoOfQues());
    stringBuilder.append(" Questions");
    textView.setText(stringBuilder.toString());
    paramMyViewHolder.tvType.setText(testItem.getTestType());
    paramMyViewHolder.btnCardAction.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Context context = TestAdapter.this.mContext;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(position);
            stringBuilder.append(" Pressed");
            Toast.makeText(context, stringBuilder.toString(), 1).show();
            TestAdapter testAdapter = TestAdapter.this;
            testAdapter.launchTestActivity(testAdapter.mContext);
          }
        });
  }
  
  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.test_card, paramViewGroup, false));
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder {
    public Button btnCardAction;
    
    public TextView tvName;
    
    public TextView tvQuestions;
    
    public TextView tvSubject;
    
    public TextView tvTime;
    
    public TextView tvType;
    
    public MyViewHolder(View param1View) {
      super(param1View);
      this.tvName = (TextView)param1View.findViewById(R.id.test_name);
      this.tvSubject = (TextView)param1View.findViewById(R.id.test_subject);
      this.tvTime = (TextView)param1View.findViewById(R.id.test_time);
      this.tvQuestions = (TextView)param1View.findViewById(R.id.test_questions);
      this.tvType = (TextView)param1View.findViewById(R.id.test_type);
      this.btnCardAction = (Button)param1View.findViewById(R.id.test_card_action);
    }
  }
}


