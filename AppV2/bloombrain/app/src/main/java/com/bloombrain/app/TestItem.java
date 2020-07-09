package com.bloombrain.app;

public class TestItem {
  private String name;
  
  private int noOfQues;
  
  private String subject;
  
  private String testType;
  
  private int thumbnail;
  
  private int time;
  
  public TestItem() {}
  
  public TestItem(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3) {
    this.name = paramString1;
    this.subject = paramString2;
    this.noOfQues = paramInt1;
    this.time = paramInt2;
    this.testType = paramString3;
    this.thumbnail = paramInt3;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getNoOfQues() {
    return this.noOfQues;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String getTestType() {
    return this.testType;
  }
  
  public int getThumbnail() {
    return this.thumbnail;
  }
  
  public int getTime() {
    return this.time;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setNoOfQues(int paramInt) {
    this.noOfQues = paramInt;
  }
  
  public void setSubject(String paramString) {
    this.subject = paramString;
  }
  
  public void setTestType(String paramString) {
    this.testType = paramString;
  }
  
  public void setThumbnail(int paramInt) {
    this.thumbnail = paramInt;
  }
  
  public void setTime(int paramInt) {
    this.time = paramInt;
  }
}


