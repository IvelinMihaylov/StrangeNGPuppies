package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "subscriber")
public class Subscriber {
  
  @Id
  @Column (name = "phonenumber")
  private String phonenumber;
  
  @Column (name = "firstname")
  private String firstname;
  
  @Column (name = "lastname")
  private String lastname;
  
  @Column (name = "egn")
  private String egn;
  
  @Column (name = "address")
  private String address;
  
  public Subscriber() {
  }
  
  public Subscriber(String phonenumber, String firstname, String lastname, String egn, String address) {
    this.phonenumber = phonenumber;
    this.firstname = firstname;
    this.lastname = lastname;
    this.egn = egn;
    this.address = address;
  }
  
  public String getPhonenumber() {
    return phonenumber;
  }
  
  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public String getEgn() {
    return egn;
  }
  
  public void setEgn(String egn) {
    this.egn = egn;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
}
