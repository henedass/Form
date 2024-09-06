package com.example.hw;

import java.util.ArrayList;
import java.util.Collections;

public class AddressSortingApplication {

    public static void main(String[] args) {
        // Create a list of Address objects
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Tehran", "Iran", "Satarkhan"));
        addresses.add(new Address("Isfahan", "Iran", "Jolfa"));
        addresses.add(new Address("Paris", "France", "5th Avenue"));
        addresses.add(new Address("Berlin", "Germany", "einPlatz"));

        
        Collections.sort(addresses);

       
        System.out.println("Sorted by city :");
        printAddresses(addresses);

        
        
        addresses.sort((a1, a2) -> a1.getCountry().compareTo(a2.getCountry()));

       
        System.out.println("\nSorted by country:");
        printAddresses(addresses);
    }

    
    private static void printAddresses(ArrayList<Address> addresses) {
        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}

