package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Table (name = "billingrecord")
public class BillingRecord {
  @Id
  @Column (name = "id")
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column (name = "startDate")
  private LocalDate startDate;
  
  @Column (name = "endDate")
  private LocalDate endDate;
  
  @Column (name = "amount")
  private double amount;
  
  @Column (name = "currently")
  private String currently;
  
  @Column (name = "status")
  private String status;
  
  public BillingRecord() {
  }
  
  public BillingRecord(LocalDate startDate, LocalDate endDate, double amount, String currently, String status) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.amount = amount;
    this.currently = currently;
    this.status = status;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public LocalDate getStartDate() {
    return startDate;
  }
  
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
  
  public LocalDate getEndDate() {
    return endDate;
  }
  
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public void setAmount(double amount) {
    this.amount = amount;
  }
  
  public String getCurrently() {
    return currently;
  }
  
  public void setCurrently(String currently) {
    this.currently = currently;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
}
