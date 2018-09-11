package com.cagmemini.serviciosya.dao;

import com.cagmemini.serviciosya.beans.domain.Occupation;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

    private Connection _connection;

    public OccupationJdbcDao(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Occupation> findAllOccupations() {

        ResultSet result = null;
        try {
            result = getStatement().executeQuery("SELECT * FROM Ocupattion");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return parseResults(result);

    }

    @Override
    public void add(Occupation occupation) {

        if( searchById( occupation.getId() ) != null ){

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO Ocupattion VALUES(");
            query.append( occupation.getId() ).append(", ");
            query.append( occupation.getName() ).append(", ");
            query.append( occupation.getDescription() );

            try {
                getStatement().executeQuery( query.toString() );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        closeConnection();

    }

    @Override
    public Occupation searchById(String id) {

        ResultSet result = null;
        try {
            result = getStatement().executeQuery("SELECT * FROM Ocupattion WHERE Id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return parseResults(result).get(0);

    }

    private List<Occupation> parseResults(ResultSet res) {


        List<Occupation> ret = new LinkedList<>();
        try {

            while( res.next() ){
                ret.add( new Occupation(
                        ""+ res.getInt("Id"),
                        "" + res.getString("Name"),
                        "" + res.getString("Description")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public void update(String id, Occupation occupation) {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Ocupattion SET Name = \'").append( occupation.getName() );
        sb.append("\', Description = ").append( occupation.getDescription( ));
        sb.append("WHERE Id=").append( occupation.getId() );

        try {
            getStatement().executeQuery( sb.toString() );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    @Override
    public void delete(String id) {

        try {
            getStatement().executeQuery("DELETE * FROM Ocupattion WHERE Id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    private void getConnection(){
        try {
            _connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/serviciosya", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Statement getStatement(){
        getConnection();
        Statement ret = null;
        try {
            ret = _connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private void closeConnection(){
        try {

            do {
                _connection.close();
            } while ( !_connection.isClosed() );

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
