package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;

@Entity
@Table (name = "service")
public class Service {
  @Id
  @Column (name = "id")
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column (name = "name")
  private String name;
  
  @Column (name = "subscriber")
  private String subscriber;
  
  @Column (name = "client")
  private String client;
  
  @Column (name = "user")
  private String user;
  
  @Column (name = "billingRecord")
  private String billingRecord;
  
  public Service() {
  }
  
  public Service(String name, String subscriber, String client, String user, String billingRecord) {
    this.name = name;
    this.subscriber = subscriber;
    this.client = client;
    this.user = user;
    this.billingRecord = billingRecord;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSubscriber() {
    return subscriber;
  }
  
  public void setSubscriber(String subscriber) {
    this.subscriber = subscriber;
  }
  
  public String getClient() {
    return client;
  }
  
  public void setClient(String client) {
    this.client = client;
  }
  
  public String getUser() {
    return user;
  }
  
  public void setUser(String user) {
    this.user = user;
  }
  
  public String getBillingRecord() {
    return billingRecord;
  }
  
  public void setBillingRecord(String billingRecord) {
    this.billingRecord = billingRecord;
  }
}
