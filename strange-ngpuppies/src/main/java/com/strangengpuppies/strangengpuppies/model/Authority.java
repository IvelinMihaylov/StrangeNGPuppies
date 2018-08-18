package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "authority")
public class Authority {
  @Id
  @Column (name = "username")
  private String username;
  
  @Column (name = "role")
  private String role;
  
  public Authority() {
  }
  
  public Authority(String username, String role) {
    this.username = username;
    this.role = role;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getRole() {
    return role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
}
