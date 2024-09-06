package com.example.hw;
import java.util.*;
import java.util.stream.Collectors;
public class Student {
	

	
	    private String firstName;
	    private String lastName;
	    private int age;
	    private int grade; // grade from 0 to 20

	    // Constructor
	    public Student(String firstName, String lastName, int age, int grade) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.age = age;
	        this.grade = grade;
	    }

	    // Getters
	    public String getFirstName() { return firstName; }
	    public String getLastName() { return lastName; }
	    public int getAge() { return age; }
	    public int getGrade() { return grade; }

	    @Override
	    public String toString() {
	        return String.format("%s %s, Age: %d, Grade: %d", firstName, lastName, age, grade);
	    }

	    


}
