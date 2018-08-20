package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "service")
    private List<Bill> bills;

}
