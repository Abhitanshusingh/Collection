package com.bridgelabz.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> personName = new LinkedList<String>();
        personName.add("Sagar singh");
        personName.addLast("Himanshu singh");
        personName.add("Abhitanshu singh");
        personName.addFirst("Shubham singh");
        personName.add(4, "King");
        System.out.println(personName.contains("King"));
        System.out.println(personName.contains("Singh"));
        System.out.println(personName.indexOf("Shubham singh"));
        personName.remove("Singh");
        personName.remove(4);
        personName.forEach(name -> System.out.println(name));
    }

}
