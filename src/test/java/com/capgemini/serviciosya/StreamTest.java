package com.capgemini.serviciosya;

import java.util.LinkedList;
import java.util.List;

public class StreamTest {

    public static void main(String... args){

        List<Simpson> list = new LinkedList<>();
        list.add(new Simpson("Marge", "Simpson", 24));
        list.add(new Simpson("Homero", "Simpson", 25));
        list.add(new Simpson("Bart", "Simpson", 10));
        list.add(new Simpson("Lisa", "Simpson", 8));

        List<Simpson> less18 = new LinkedList<>();
        list.stream().filter( s -> s.getAge()<18 ).sorted().forEach(less18::add);
        System.out.println(less18);

        List<Simpson> greater18 = new LinkedList<>();
        list.stream().filter( s -> s.getAge()>=18 ).forEach(greater18::add);
        System.out.println(greater18);

        list.forEach(System.out::println);

    }


}

class Simpson implements Comparable<Simpson> {

    private String _name, _lastName;
    private Integer _age;

    public Simpson(String name, String lastName, Integer age){
        _name = name;
        _lastName = lastName;
        _age = age;
    }

    public Integer getAge() {
        return _age;
    }

    public String getName() {
        return _name;
    }

    public String getLastName() {
        return _lastName;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append( "Simpson:{ Name: " ).append( getName() ).append(", ");
        sb.append( "LastName: " ).append( getLastName() ).append(", ");
        sb.append( "Age: " ).append( getAge() ).append("}");
        return sb.toString();
    }

    @Override
    public int compareTo(Simpson s) {
        return getAge() - s.getAge();
    }
}
