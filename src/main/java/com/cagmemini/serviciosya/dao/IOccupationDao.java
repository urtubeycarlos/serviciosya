
package com.cagmemini.serviciosya.dao;


import java.util.List;

import com.cagmemini.serviciosya.beans.domain.Occupation;

public interface IOccupationDao {

    List<Occupation> findAllOccupations ();
    void add (Occupation occupation);
    Occupation searchById(String id);
    void update(String id, Occupation occupation);
    void delete(String id);

}
