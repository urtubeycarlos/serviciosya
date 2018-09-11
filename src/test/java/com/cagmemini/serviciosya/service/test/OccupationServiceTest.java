
package com.cagmemini.serviciosya.service.test;


import java.util.List;

import com.cagmemini.serviciosya.dao.IOccupationDao;
import com.cagmemini.serviciosya.dao.OccupationDaoMemory;
import org.junit.Assert;
import org.junit.Test;

import com.cagmemini.serviciosya.beans.domain.Occupation;
import com.cagmemini.serviciosya.service.OccupationService;


public class OccupationServiceTest {


    private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao = new OccupationDaoMemory ();


    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {


        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        List<Occupation> init = this.occupationDao.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        Assert.assertTrue (init.size()+1 == end.size());
    }

    @Test
    public void testSearchOccupation(){
        this.occupationService.setOccupationDao(this.occupationDao);

        Occupation o = new Occupation("50", "Tester", "Testear apps");
        this.occupationService.addOccupation(o);

        Occupation found = this.occupationService.searchOccupation("50");
        Occupation notFound = this.occupationService.searchOccupation("idInexistente123TiraNull");

        Assert.assertTrue(found.getName().equals(o.getName()));
        Assert.assertFalse(notFound instanceof Occupation);
    }

    @Test
    public void testDeleteOccupation(){
        this.occupationService.setOccupationDao(this.occupationDao);

        Occupation o = new Occupation("60", "Name", "Description");
        occupationService.addOccupation(o);

        List<Occupation> list1 = this.occupationService.findAllOccupations();

        this.occupationService.deleteOccupation("60");
        List<Occupation> list2 = this.occupationService.findAllOccupations();

        Assert.assertTrue( list1.size() == list2.size()+1 );
    }

}