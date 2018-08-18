package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "client")
public class Client {
  @Id
  @Column (name = "username")
  private String username;
  @Column (name = "password")
  private String password;
  @Column (name = "eik")
  private Integer eik;
  
  public Client(String username, String password, Integer eik) {
    this.username = username;
    this.password = password;
    this.eik = eik;
  }
  
  public Client() {
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Integer getEik() {
    return eik;
  }
  
  public void setEik(Integer eik) {
    this.eik = eik;
  }
  
}
