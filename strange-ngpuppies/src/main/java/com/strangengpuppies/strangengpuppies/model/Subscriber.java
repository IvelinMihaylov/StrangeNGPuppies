package com.strangengpuppies.strangengpuppies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    private String phoneNumber;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "EGN")
    private String egn;

    @ManyToOne(cascade = CascadeType.ALL)
    private User bank;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "subscriber")
    private List<Bill> bills;
}
