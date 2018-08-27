package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriberID")
    private int id;

    @NotNull
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @NotNull
    @Column(name = "firstname")
    private String firstName;
    
    @NotNull
    @Column(name = "lastname")
    private String lastName;
    
    @NotNull
    @Column(name = "EGN")
    private String egn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankID")
    private User bank;
    
    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "subscriber")
    private List<Bill> bills;

    public Subscriber() {
    }


    public Subscriber(String phoneNumber, String firstName, String lastName, String egn, User bank) {
       this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.bank = bank;
        this.bills = bills;
    }

    public User getBank() {
        return bank;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEgn() {
        return egn;
    }
    
    public void setEgn(String egn) {
        this.egn = egn;
    }
    
//    public User getBank() {
//        return bank;
//    }
//
    public void setBank(User bank) {
        this.bank = bank;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
