package com.example.hw;

import java.util.Objects;

public class Address implements Comparable<Address> {
    private String city;
    private String country;
    private String street;

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
               Objects.equals(country, address.country) &&
               Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, street);
    }

    // Implementing the Comparable interface's compareTo method to compare by city
    @Override
    public int compareTo(Address other) {
        return this.city.compareTo(other.city);  // Sorting by city
    }
}
