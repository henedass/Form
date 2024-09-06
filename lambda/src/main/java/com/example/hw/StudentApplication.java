package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentApplication {
	public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Sadeneh", "Sadeghi", 21, 18),
            new Student("Saeed", "Keashani", 22, 20),
            new Student("Nila", "Fahim", 19, 15),
            new Student("Mobina", "Bayat", 21, 12),
            new Student("Sadra", "Sadeghi", 20, 17),
            new Student("Shila", "Akbari", 20, 18),
            new Student("Reza", "Moradi", 24, 18),
            new Student("Sara", "Rahimi", 221, 14),
            new Student("Roya", "Kiyani", 55, 11),
            new Student("Elham", "Zand", 30, 20)
        );

        // Sort by grade (ascending)
        List<Student> sortedByGrade = students.stream()
            .sorted(Comparator.comparingInt(Student::getGrade))
            .collect(Collectors.toList());
        System.out.println("Sorted by grade (ascending):");
        sortedByGrade.forEach(System.out::println);

        // Sort by grade (descending)
        List<Student> sortedByGradeDesc = students.stream()
            .sorted(Comparator.comparingInt(Student::getGrade).reversed())
            .collect(Collectors.toList());
        System.out.println("\nSorted by grade (descending):");
        sortedByGradeDesc.forEach(System.out::println);

        // Print students whose grade is more than 10
        System.out.println("\nStudents with grade more than 10:");
        students.stream()
            .filter(s -> s.getGrade() > 10)
            .forEach(System.out::println);

        // Print students whose grade is less than 10
        System.out.println("\nStudents with grade less than 10:");
        students.stream()
            .filter(s -> s.getGrade() < 10)
            .forEach(System.out::println);

        // Print students by age
        List<Student> sortedByAge = students.stream()
            .sorted(Comparator.comparingInt(Student::getAge))
            .collect(Collectors.toList());
        System.out.println("\nSorted by age:");
        sortedByAge.forEach(System.out::println);

        // Print average grade
        double averageGrade = students.stream()
            .mapToInt(Student::getGrade)
            .average()
            .orElse(0);
        System.out.println("\nAverage grade: " + averageGrade);

        // Print average grades more than 18
        double averageGradeMoreThan18 = students.stream()
            .filter(s -> s.getGrade() > 18)
            .mapToInt(Student::getGrade)
            .average()
            .orElse(0);
        System.out.println("Average grade for grades more than 18: " + averageGradeMoreThan18);
    }


}
