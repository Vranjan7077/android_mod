package com.bloombrain.app;

import java.util.ArrayList;
import java.util.List;

public class PlanItem {
  ArrayList<String> planDetails;
  
  String planName;
  
  String planPrice;
  
  public PlanItem() {}
  
  public PlanItem(String paramString1, String paramString2, List<String> paramList) {
    this.planName = paramString1;
    this.planPrice = paramString2;
    this.planDetails = (ArrayList<String>)paramList;
  }
  
  public ArrayList<String> getPlanDetails() {
    return this.planDetails;
  }
  
  public String getPlanName() {
    return this.planName;
  }
  
  public String getPlanPrice() {
    return this.planPrice;
  }
  
  public void setPlanDetails(ArrayList<String> paramArrayList) {
    this.planDetails = paramArrayList;
  }
  
  public void setPlanName(String paramString) {
    this.planName = paramString;
  }
  
  public void setPlanPrice(String paramString) {
    this.planPrice = paramString;
  }
}


