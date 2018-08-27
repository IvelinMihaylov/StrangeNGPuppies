package com.strangengpuppies.strangengpuppies.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

@Entity
@Table (name = "bills")
public class Bill {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriberID", insertable = false)
    private Subscriber subscriber;

    @Column(name = "startdate")
    private String startDate;

    @Column(name = "enddate")
    private String endDate;
=======
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
  
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @NotNull
  @Column (name = "startdate")
  private LocalDateTime startDate;
  
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @NotNull
  @Column (name = "enddate")
  private LocalDateTime endDate;
  
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
  
  public Bill(Service service, Subscriber subscriber, LocalDateTime startDate, LocalDateTime endDate, double amount, String currency) {
    this.service = service;
    this.subscriber = subscriber;
    this.startDate = startDate;
    this.endDate = endDate;
    this.amount = amount;
    this.currency = currency;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public LocalDateTime getStartDate() {
    return startDate;
  }
  
  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }
  
  public LocalDateTime getEndDate() {
    return endDate;
  }
  
  public void setEndDate(LocalDateTime endDate) {
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
>>>>>>> branch-ivelin

  public void setService(Service service) {
    this.service = service;
  }

<<<<<<< HEAD
    @Column(name = "paymentdate")
    private String paymentDate;

    public Bill() {
    }

    public Bill(Service service, Subscriber subscriber, String startDate, String endDate, double amount, String paymentDate) {
        this.service = service;
        this.subscriber = subscriber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
=======
//  public Subscriber getSubscriber() {
//    return subscriber;
//  }
//
//  public void setSubscriber(Subscriber subscriber) {
//    this.subscriber = subscriber;
//  }
>>>>>>> branch-ivelin
}
