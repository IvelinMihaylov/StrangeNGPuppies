package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "EIK")
    private String eik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID")
    private Role role;

//    @OneToMany(cascade = CascadeType.ALL,
//    fetch = FetchType.EAGER,
//    mappedBy = "bank")
//    private List<Subscriber> subscribers;
    
    public User() {
    }
    
    public User(String username, String password, String email, String eik, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.eik = eik;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEik() {
        return eik;
    }
    
    public void setEik(String eik) {
        this.eik = eik;
    }
    
}
