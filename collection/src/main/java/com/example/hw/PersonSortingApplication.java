package com.example.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonSortingApplication {

	    public static void main(String[] args) {
	     
	        ArrayList<Person> people = new ArrayList<>();

	        
	        people.add(new Person("Sadeneh", "Sadeghi", 22, new Address("Tehran", "Iran", "Satarkhan")));
	        people.add(new Person("Saeed", "Keshani", 25, new Address("Isfahan", "Iran", "Jolfa")));
	        people.add(new Person("Nila", "Fahim", 40, new Address("Paris", "France", "5th Avenue")));
	        people.add(new Person("Mobina", "Bayat", 35, new Address("Berlin", "Germany", "einPlatz")));

	        
	        System.out.println("Initial List of People:");
	        printPeople(people);

	        
	        Person searchPerson = new Person("Sadeneh", "Sadeghi", 22, new Address("Tehran", "Iran", "Satarkhan"));
	        System.out.println("\nContains 'Sadeneh Sadeghi'? " + people.contains(searchPerson));

	        // Remove a person
			/*
			 * people.remove(searchPerson);
			 * System.out.println("\nAfter removing 'John Doe':"); printPeople(people);
			 */

	        
	        Collections.sort(people);
	        System.out.println("\nSorted by last name:");
	        printPeople(people);

	  
	        int index = Collections.binarySearch(people, new Person("Nila", "Fahim", 40, null));
	        System.out.println("\nIndex of 'Nila Fahim' (using binary search): " + index);

	        
	        people.sort(Comparator.comparingInt(Person::getAge));
	        System.out.println("\nSorted by age:");
	        printPeople(people);
	    }

	   
	    private static void printPeople(ArrayList<Person> people) {
	        for (Person person : people) {
	            System.out.println(person);
	        }
	    }
	
}


