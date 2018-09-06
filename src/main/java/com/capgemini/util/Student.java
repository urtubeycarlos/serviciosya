package com.capgemini.util;

import java.util.Objects;

public class Student {

    private String DNI;

    public void setDNI(String dni){
        this.DNI = dni;
    }

    public String getDNI(){
        return this.DNI;
    }

    @Override
    public boolean equals(Object o){
        if( !(o instanceof Student) || o == null)
            return false;
        Student in = (Student) o;
        return getDNI().equals( in.getDNI() );
    }

    @Override
    public int hashCode(){
        return this.DNI.hashCode();
    }

    public static void main(String... args){

        Student e1 = new Student();
        e1.setDNI("1234");

        Student e2 = new Student();
        e2.setDNI("1234");

        System.out.println( e1 == e2 );
        System.out.println( e1.equals(e2) );
        System.out.println( Objects.equals(e1, e2) );

    }

}
