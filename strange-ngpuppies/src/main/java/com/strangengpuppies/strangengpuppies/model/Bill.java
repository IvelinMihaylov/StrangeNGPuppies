package com.strangengpuppies.strangengpuppies.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

@Entity
@Table(name = "bills")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billID")
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    private Service service;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriberID")
    private Subscriber subscriber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Column(name = "startdate")
    private String startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Column(name = "enddate")
    private String endDate;

    @NotNull
    @Column(name = "amount")
    private double amount;

    @NotNull
    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private String status;

    public Bill(Service service, Subscriber subscriber, String startDate, String endDate, double amount, String currency) {
        this.service = service;
        this.subscriber = subscriber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.currency = currency;
    }

    @Column(name = "paymentdate")
    private String paymentDate;

    public Bill() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
