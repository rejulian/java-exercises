package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Multiple Bounds
 *
 * This exercise demonstrates how a type parameter can have multiple bounds.
 * The syntax is: <T extends ClassBound & InterfaceBound1 & InterfaceBound2>
 * If a class is included, it must come first.
 *
 * Complete the TODOs below.
 */
public class MultipleBounds {

    // TODO: 1 - Create an interface called Printable with a single method:
    //  void print();
    interface Printable{
        void print();
    }

    // TODO: 2 - Create a static generic method:
    //  <T extends Comparable<T> & Printable> T findMin(List<T> list)
    //  It should return the smallest element using compareTo().
    //  If the list is empty, return null.
    //  This method requires T to be both Comparable AND Printable.
    public static <T extends Comparable<T> & Printable> T findMin(List<T> list){
        if (list.isEmpty()) {
            return null;
        }
        T minElement = list.getFirst();
        for(T element : list) {
            if(element.compareTo(minElement) < 0){
                minElement = element;
            }
        }

        return minElement;
    }

    // TODO: 3 - Create a static inner class Student that implements both
    //  Comparable<Student> and Printable.
    //  Student should have a "name" (String) and "grade" (double) field,
    //  a constructor, compareTo() based on grade (ascending),
    //  and print() that prints "Student{name='...', grade=...}".
    //  Also override toString() with the same format as print().
    static class Student implements Comparable<Student>, Printable {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public void print() {
            System.out.println("Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}');
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(this.grade, other.grade);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }

    public static void main(String[] args) {

        // TODO: 4 - Create a List<Student> with at least 3 students having
        //  different grades. Call findMin() to find the student with the
        //  lowest grade. Print the result using the print() method.
        Student julian = new Student("Julian", 9.8);
        Student john = new Student("John", 8.9);
        Student delfina = new Student("Delfina", 9.7);
        List<Student> students = List.of(julian, john, delfina);
        System.out.println(findMin(students));

        // TODO: 5 - Add a comment below explaining:
        //  (a) Why must a class bound come before interface bounds?
        //      e.g., <T extends SomeClass & SomeInterface> is valid
        //      but  <T extends SomeInterface & SomeClass> is NOT valid
        //  (b) Can you have multiple class bounds? Why or why not?
        //  (c) How many interface bounds can you have?

        // a - The class bound must come before interface bounds because Java syntax requires at most one class first, followed by any interfaces.
        // b - No. A type parameter can have only one class bound because Java does not support multiple inheritance of classes.
        // c - unlimited.
    }
}
