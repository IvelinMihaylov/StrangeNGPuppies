package com.strangengpuppies.strangengpuppies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
<<<<<<< HEAD
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "services")
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceID")
    private int id;
    
    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "service")
    @JsonIgnore
    private List<Bill> bills;

    public Service() {
    }

    public Service(String name, List<Bill> bills) {
        this.name = name;
        this.bills = bills;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

=======
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "services")
public class Service {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "serviceID")
  private int id;
  
  @NotNull
  @Size (min = 1)
  @Column (name = "name")
  private String name;
  
  @OneToMany (cascade = CascadeType.ALL,
		fetch = FetchType.EAGER,
		mappedBy = "service")
  private List<Bill> bills;
  
  public Service() {
  }
  
  public Service(@NotNull @Size (min = 1) String name) {
    this.name = name;
  }
  
  public Service(String name, List<Bill> bills) {
    this.name = name;
    this.bills = bills;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

//    public List<Bill> getBills() {
//        return bills;
//    }
//
//    public void setBills(List<Bill> bills) {
//        this.bills = bills;
//    }
>>>>>>> branch-ivelin
}
