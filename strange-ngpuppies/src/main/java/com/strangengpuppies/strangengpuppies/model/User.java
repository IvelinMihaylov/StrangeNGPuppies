package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "EIK")
    private String eik;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "bank")
    private List<Subscriber> subscribers;
}
