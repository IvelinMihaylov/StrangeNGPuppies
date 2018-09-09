package com.strangengpuppies.strangengpuppies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "phonenumber")
    private String phoneNumber;

    @NotNull
    @Size(min = 1)
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @Size(min = 1)
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Size(min = 1)
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
    }

    public Subscriber(@NotNull @Size(min = 10, max = 10) String phoneNumber, @NotNull @Size(min = 1) String firstName, @NotNull @Size(min = 1) String lastName, @NotNull @Size(min = 1) String egn, User bank, List<Bill> bills) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.bank = bank;
        this.bills = bills;
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

    @JsonIgnore
    public User getBank() {
        return bank;
    }


    public void setBank(User bank) {
        this.bank = bank;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public Subscriber clone() {
        Subscriber newSubscriber = new Subscriber();
        newSubscriber.setPhoneNumber(phoneNumber);
        newSubscriber.setFirstName(firstName);
        newSubscriber.setLastName(lastName);
        newSubscriber.setEgn(egn);
        newSubscriber.setBills(new ArrayList<>());
        newSubscriber.setBank(bank);
        return newSubscriber;
    }

}
