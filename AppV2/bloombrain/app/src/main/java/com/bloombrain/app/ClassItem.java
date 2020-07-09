package com.bloombrain.app;

public class ClassItem {
  String classTime;
  
  String link;
  
  String subject;
  
  String topic;
  
  public ClassItem() {}
  
  public ClassItem(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.subject = paramString1;
    this.classTime = paramString2;
    this.topic = paramString3;
    this.link = paramString4;
  }
  
  public String getClassTime() {
    return this.classTime;
  }
  
  public String getLink() {
    return this.link;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String getTopic() {
    return this.topic;
  }
  
  public void setClassTime(String paramString) {
    this.classTime = paramString;
  }
  
  public void setLink(String paramString) {
    this.link = paramString;
  }
  
  public void setSubject(String paramString) {
    this.subject = paramString;
  }
  
  public void setTopic(String paramString) {
    this.topic = paramString;
  }
}

