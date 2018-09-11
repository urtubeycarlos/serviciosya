
package com.cagmemini.serviciosya.dao;


import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.*;

import com.cagmemini.serviciosya.beans.domain.Occupation;


public class OccupationDaoMemory implements IOccupationDao {

    private Map<String, Occupation> occupations;

    public OccupationDaoMemory() {

        super ();

        this.occupations = new TreeMap<>();

        // Load occupations.
        Occupation o1 = new Occupation (randomAlphabetic(5),
                                        "Entandador de Serpientes",
                                    "Entandador de Serpientes");

        Occupation o2 = new Occupation (randomAlphabetic(5),
                                       "Cuidador de Suegras",
                                   "Cuidador de Suegras");

        // Add values to map.
        this.occupations.put (o1.getId (), o1);
        this.occupations.put (o2.getId (), o2);
    }

    @Override
    public List<Occupation> findAllOccupations () {

        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {

            list.add (item.getValue ());
        }

        // Return the occupations.
        return list;
    }

    @Override
    public void add (Occupation occupation) {
        this.occupations.put (occupation.getId (), occupation);
    }

    @Override
    public Occupation searchById(String id){
        Occupation ocu ;

        try {
            ocu = this.occupations.get(id);
            return ocu;
        } catch (NullPointerException npe){
            System.out.println("The key have no value mapped");
            return null;
        }
    }

    @Override
    public void delete(String id){
        Occupation ocu = this.occupations.remove(id);
//        System.out.println("Delete() >> " + ocu);

        if(ocu==null) throw new NullPointerException() ;
//        else System.out.println("Succesfully removed " + ocu);
    }

    @Override
    public void update (String id, Occupation ocu){
        this.delete( id );
        ocu.setId(id);
        this.add( ocu );
    }
}