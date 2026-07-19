package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            integerArrayList.add(i);
            integerLinkedList.add(i);
        }

        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        long startArray = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerArrayList.add(0, i);
        }
        long endArray = System.nanoTime();

        long startLinked = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerLinkedList.add(0, i);
        }
        long endLinked = System.nanoTime();

        System.out.println("ArrayList: " + (endArray - startArray) / 1_000_000.0 + " ms");
        System.out.println("LinkedList: " + (endLinked - startLinked) / 1_000_000.0 + " ms");

        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        long startArrayEnd = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerArrayList.add(i);
        }
        long endArrayEnd = System.nanoTime();

        long startLinkedEnd = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerLinkedList.add(i);
        }
        long endLinkedEnd = System.nanoTime();

        System.out.println();
        System.out.println("ArrayList adding last: " + (endArrayEnd - startArrayEnd) / 1_000_000.0 + " ms");
        System.out.println("LinkedList adding last: " + (endLinkedEnd - startLinkedEnd) / 1_000_000.0 + " ms");

        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        long startGetArray = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerArrayList.get(integerArrayList.size() / 2);
        }
        long endGetArray = System.nanoTime();

        long startGetLinked = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            integerLinkedList.get(integerArrayList.size() / 2);
        }
        long endGetLinked = System.nanoTime();

        System.out.println();
        System.out.println("ArrayList getting: " + (endGetArray - startGetArray) / 1_000_000.0 + " ms");
        System.out.println("LinkedList getting: " + (endGetLinked - startGetLinked) / 1_000_000.0 + " ms");


        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other
        System.out.println("LinkedList is faster for insertions at the beginning because it only updates node references.");
        System.out.println("ArrayList is slower for insertions at the beginning because it must shift all existing elements.");
        System.out.println("ArrayList is faster for random access (get by index) because elements are stored in contiguous memory.");
        System.out.println("LinkedList is slower for random access because it must traverse the list node by node.");
        System.out.println("Choose ArrayList for frequent index access and append operations.");
        System.out.println("Choose LinkedList for frequent insertions or removals at the beginning.");
    }
}
