
package com.capgemini.serviciosya.beans;

import javax.persistence.*;


@Entity (name = "City")
@Table (name = "city")
public class City {


    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name="province_id")
    private Province province;


    public City() {

        super ();
    }

    public City(int id, String name, Province province) {

        super ();

        this.id = id;
        this.name = name;
        this.province = province;
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

    public Province getProvince () {

        return province;
    }

    public void setProvince (Province province) {

        this.province = province;
    }


    @Override
    public String toString () {

        return this.name;
    }
}