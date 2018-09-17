
package com.capgemini.serviciosya.beans;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity (name = "Country")
@Table (name = "country")
public class Country {


    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @OneToMany (mappedBy = "country", fetch = FetchType.EAGER)
    private Set<Province> provinces = new HashSet<> ();


    public Country () {

        super ();
    }

    public Country (int id, String name) {

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

    public Set<Province> getProvinces () {

        return provinces;
    }

    public void setProvinces (Set<Province> provinces) {

        this.provinces = provinces;
    }

    @Override
    public String toString () {

        return this.name;
    }
}