
package com.capgemini.serviciosya.beans;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity (name = "Occupation")
@Table (name = "occupation")
public class Occupation {


    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToMany (mappedBy="occupations")
    private Set<Provider> providers = new HashSet<>();


    public Occupation() {

        super ();
    }

    public Occupation(int id, String name) {

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

    public Set<Provider> getProviders() {

        return providers;
    }

    public void setProviders(Set<Provider> providers) {

        this.providers = providers;
    }

  @Override
    public String toString () {

        return this.name;
    }
}