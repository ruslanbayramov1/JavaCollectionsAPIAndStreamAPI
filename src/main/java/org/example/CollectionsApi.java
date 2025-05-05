package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsApi {
    public static void doBasic()
    {
        // ArrayList
        List<String> strArrList = new ArrayList<>();

        strArrList.add("Josh");
        strArrList.add("John");
        strArrList.addFirst("Adam");
        strArrList.addLast("Barbara");
        strArrList.remove("Josh");

        System.out.println(strArrList.isEmpty());
        System.out.println(strArrList.contains("Josh"));
        System.out.println(strArrList.getFirst());

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Ford");
        linkedList.add("BMW");
        linkedList.remove(1);

        // LinkedList as queue - FIFO
        LinkedList<Integer> linkedListAsQueue = new LinkedList<Integer>();
        linkedListAsQueue.offer(16);
        linkedListAsQueue.offer(32);
        linkedListAsQueue.offer(25);
        System.out.println("Element removed from queue is: " + linkedListAsQueue.poll()); // removed first element 16, FIFO

        // LinkedList as stack - LIFO
        LinkedList<Integer> linkedListAsStack = new LinkedList<Integer>();
        linkedListAsStack.push(16);
        linkedListAsStack.push(32);
        linkedListAsStack.push(25);
        System.out.println("Element popped from stack is: " + linkedListAsStack.pop()); // removed last element 25, LIFO
        System.out.println("First element in stack is: " + linkedListAsStack.getFirst()); // 32 - LIFO

        // Set - not allows duplicate values
        Set<Integer> set = new HashSet<Integer>();
        set.add(3);
        set.add(4);
        set.add(3);
        System.out.println(set); // [3, 4]

        // HashMap - key value pair
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        System.out.println(hashMap.get(1));
    }

    public static void doStreamApiTaskOne()
    {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        String res = numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Task one: " + res);
    }

    public static void doStreamApiTaskTwo()
    {
        List<String> words = List.of("apple", "banana", "cherry", "kiwi", "pear", "melon");
        // Length are keys, and words are vales as List<String>
        Map<Integer, List<String>> groupedWords = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Task two: " + groupedWords);
    }

    public static void doStreamApiTaskThree()
    {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Long res = numbers.stream().filter(number -> number % 2 == 1).collect(Collectors.counting());
        System.out.println("Task three: " + res);
    }

    public static void doStreamApiTaskFour()
    {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        IntSummaryStatistics numberStats =  numbers.stream().collect(Collectors.summarizingInt(Integer::valueOf));
        System.out.println("Task four: " + numberStats);
        System.out.printf("Task four extra: Max: %d, Min: %d, Average: %.2f, Count: %d\n", numberStats.getMax(), numberStats.getMin(), numberStats.getAverage(), numberStats.getCount());
    }

    public static void doStreamTaskFive()
    {
        List<Integer> numbers = List.of(5, 3, 8, 3, 1, 5, 9, 1, 2);
        // V1
        Set<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toSet());
        // V2
        List<Integer> sortedNumbersV2 = numbers.stream().distinct().sorted().toList();
        System.out.println("Task five v1: " + sortedNumbers);
        System.out.println("Task five v2: " + sortedNumbersV2);
    }
}
