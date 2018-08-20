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
}
