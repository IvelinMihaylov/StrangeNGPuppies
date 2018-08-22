package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;

@Entity
@Table (name = "bills")
public class Bill {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "billID")
  private int id;
  
  @ManyToOne (cascade = CascadeType.ALL)
  @JoinColumn (name = "serviceID")
  private Service service;
  
  @ManyToOne (cascade = CascadeType.ALL)
  @JoinColumn (name = "subscriberID")
  private Subscriber subscriber;
  
  @Column (name = "startdate")
  private String startDate;
  
  @Column (name = "enddate")
  private String endDate;
  
  @Column (name = "amount")
  private double amount;
  
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
}
