
package com.capgemini.serviciosya.dao.test;


import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.OccupationDaoJDBC;

import java.util.List;


public class OccupationServiceTest {


    private static final Logger logger = Logger.getLogger (OccupationServiceTest.class);


    @Test
    public void testAdd () {

        try {

            // Insert new value.
            logger.info ("Starting occupation add test.");
            IOccupationDao dao = new OccupationDaoJDBC ();

            logger.debug ("Inserting new occupation.");
            Occupation c = new Occupation ();
            c.setName ("Rum Tester.");
            c.setDescription ("xxxx");
            dao.create (c);

           logger.debug ("Checking test result.");
           List<Occupation> list = dao.findAll ();

           boolean r = Boolean.FALSE;

           for (Occupation item: list) {

               if (item.getName ().equals (c.getName ())) {
                   r = Boolean.TRUE;
                   break;
               }
           }

           logger.info ("Finishing the test...");
           Assert.assertTrue ("Failure inserting new Occupation.", r);


        } catch (Exception e) {

            Assert.assertNull (e);
        }
    }

}