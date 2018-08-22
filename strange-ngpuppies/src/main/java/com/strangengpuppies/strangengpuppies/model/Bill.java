package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL)
    private Subscriber subscriber;

    @Column(name = "startdate")
    private String startDate;

    @Column(name = "enddate")
    private String endDate;

    @Column(name = "amount")
    private double amount;

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
}
