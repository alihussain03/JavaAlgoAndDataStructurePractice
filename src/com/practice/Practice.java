package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        HashMap<String, Integer> studentScores = new HashMap<>();
        studentScores.put("John", 85);
        studentScores.put("Jane", 65);
        studentScores.put("Tom", 90);
        studentScores.put("Lucy", 70);

        Map<String, Integer> filteredStudents = studentScores.entrySet().stream().filter(entry -> entry.getValue() >= 90).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filteredStudents.forEach((s, integer) -> System.out.println(s + " " + integer));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<Integer> length = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(length);

        List<String> sortedString = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedString);

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        long count = names.stream().filter(name -> name.length() > 5).count();
        System.out.println(count);

        String result = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(result);

        int max = numbers.stream().max(Comparator.naturalOrder()).get();

        // Find minimum value
        int min = numbers.stream().min(Comparator.naturalOrder()).get();

        System.out.println(max);
        System.out.println(min);

        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        groupedByLength.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}
