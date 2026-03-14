package com.itk;

import java.util.*;
import java.util.stream.*;

class Student {

    private String name;
    private Map<String, Integer> grades;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return name + " -> " + grades;
    }
}

public class ParallelStreamCollectMapAdvancedExample {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        // 1️⃣ Print all students
        System.out.println("All Students:");
        students.forEach(System.out::println);


        // 2️⃣ Print each student's grades
        System.out.println("\nEach Student Grades:");

        students.forEach(student -> {
            System.out.println(student.getName() + " -> " + student.getGrades());
        });


        // 3️⃣ Flatten subject-grade pairs
        System.out.println("\nFlattened Subject-Grade Pairs:");

        students.stream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " = " + entry.getValue())
                );


        // 4️⃣ Group grades by subject
        Map<String, List<Integer>> groupedGrades =
                students.stream()
                        .flatMap(student -> student.getGrades().entrySet().stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                        ));

        System.out.println("\nGrouped Grades by Subject:");
        groupedGrades.forEach((subject, grades) ->
                System.out.println(subject + " -> " + grades)
        );


        // 5️⃣ Calculate average grades using Parallel Stream
        Map<String, Double> averageGrades =
                students.parallelStream()
                        .flatMap(student -> student.getGrades().entrySet().stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.averagingInt(Map.Entry::getValue)
                        ));

        System.out.println("\nAverage Grades Per Subject:");
        averageGrades.forEach((subject, avg) ->
                System.out.println(subject + " : " + avg)
        );
    }
}