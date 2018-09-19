
package com.capgemini.serviciosya.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Provider")
@Table(name = "provider")
public class Provider {

    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @Column (name = "last_name", length = 48, nullable = false)
    private String lastName;

    @Column (name = "phone", length = 48, nullable = false, unique = true)
    private String phone;

    @Column (name = "dni", nullable = false, unique = true)
    private Integer dni;

    @Column (name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column (name = "address", length = 128, nullable = false)
    private String address;

    @Column (name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn (name="city_id")
    private City city;

    @ManyToMany (cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable (name = "occupation_x_provider",
               joinColumns = {@JoinColumn (name = "provider_id")},
               inverseJoinColumns = {@JoinColumn (name = "occupation_id")})
    private Set<Occupation> occupations = new HashSet<> ();


    public Provider () {

        super ();
    }

    public Provider(int id, String name) {

        super ();

        this.id = id;
        this.name = name;
    }


    public int getId () {

        return id;
    }

    public void setId (int id) {

        this.id = id;
    }

    public String getName () {

        return name;
    }

    public void setName (String name) {

        this.name = name;
    }

    public Set<Occupation> getOccupations() {

        return occupations;
    }

    public void setOccupations(Set<Occupation> occupations) {

        this.occupations = occupations;
    }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getDni() {
    return dni;
  }

  public void setDni(Integer dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
    public String toString () {

        return this.name;
    }
}