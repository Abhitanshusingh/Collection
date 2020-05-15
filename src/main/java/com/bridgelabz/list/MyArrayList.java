package com.bridgelabz.list;

import java.util.*;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<String> personName = new ArrayList<String>();
        personName.add("Abhi singh");
        personName.add("Shubham singh");
        personName.add("Himamshu singh");
        personName.add("Vinay singh");
        personName.set(0, "Abhitanshu singh");
        personName.remove(3);

        //Using simple for loop
        System.out.println("Using simple ForLoop");
        for (int index = 0; index < personName.size(); index++)
            System.out.println(personName.get(index));

        //Using Advanced for loop or forEach looop
        System.out.println("Using Advanced for looop");
        for (String name : personName)
            System.out.println(name);

        //ForEach java 8 Lambda Expression
        System.out.println("Using for loop with Lambda Expression");
        personName.forEach(name -> System.out.println(name));

        //Using Enumerate through the ArrayList
        Enumeration<String> enumeration = Collections.enumeration(personName);
        System.out.println("ArrayList element using Enumeration");
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());

        //While loop for iterating ArrayList
        System.out.println("While loop");
        int count = 0;
        while (personName.size() > count) {
            System.out.println(personName.get(count));
            count++;
        }

        //Looping ArrayList using iterator
        Iterator<String> iterator = personName.iterator();
        System.out.println("Iterator");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
