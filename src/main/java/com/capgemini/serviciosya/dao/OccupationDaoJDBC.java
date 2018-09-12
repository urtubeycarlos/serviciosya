
package com.capgemeini.serviciosya.dao;


import com.capgemeini.serviciosya.beans.domain.Occupation;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;



public class OccupationDaoJDBC implements IOccupationDao {


    private static final Logger logger = Logger.getLogger (OccupationDaoJDBC.class);


    public OccupationDaoJDBC () {

        super ();
    }


    @Override
    public List<Occupation> findAll () {


        // Occupations list.
        List<Occupation> occupations = new ArrayList<> ();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();


            // Execute the query.
            String sql = "select * from occupation";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);


            // Read the result.

            while (rs.next ()) {

                Occupation o = new Occupation ();
                o.setId (rs.getInt ("ID"));
                o.setName (rs.getString ("NAME"));
                o.setDescription (rs.getString ("DESCRIPTION"));

                // Add new object to list.
                occupations.add (o);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all occupations");
            throw new DaoException ("Failure searching all occupations", e);
        }

        // Return results.
        return occupations;
    }

    @Override
    public void create (Occupation occupation) {

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            String sql = "insert into occupation (name, description) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setString (1, occupation.getName ());
            ps.setString (2, occupation.getDescription ());


            // Execute the query.
            logger.debug (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();


            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new occupations!");
            }


        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new occupation!");
            throw new DaoException ("Failure inserting new occupation!", e);

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure inserting new occupation!");
            throw new DaoException (e.getMessage (), e);
        }
    }

    @Override
    public void update(Occupation target) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Occupation findById(Integer id) {
        return null;
    }
}