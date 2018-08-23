package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "bills")
public class Bill {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "billID")
  private int id;
  
  @NotNull
  @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn (name = "serviceID")
  private Service service;
  
  @NotNull
  @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn (name = "subscriberID")
  private Subscriber subscriber;
  
  @NotNull
  @Column (name = "startdate")
  private String startDate;
  
  @NotNull
  @Column (name = "enddate")
  private String endDate;
  
  @NotNull
  @Column (name = "amount")
  private double amount;
  
  @NotNull
  @Column (name = "currency")
  private String currency;
  
  @Column (name = "status")
  private String status;
  
  public Bill() {
  }
  
  public Bill(Service service, Subscriber subscriber, String startDate, String endDate, double amount, String currency, String status) {
    this.service = service;
    this.subscriber = subscriber;
    this.startDate = startDate;
    this.endDate = endDate;
    this.amount = amount;
    this.currency = currency;
    this.status = status;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getStartDate() {
    return startDate;
  }
  
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  
  public String getEndDate() {
    return endDate;
  }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public void setAmount(double amount) {
    this.amount = amount;
  }
  
  public String getCurrency() {
    return currency;
  }
  
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

//  public Subscriber getSubscriber() {
//    return subscriber;
//  }
//
//  public void setSubscriber(Subscriber subscriber) {
//    this.subscriber = subscriber;
//  }
}
