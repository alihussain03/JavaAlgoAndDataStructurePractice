package com.practiceExamples;

import com.Entity.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SomeRandomQuestions {

  public static void main(String[] args) {
    System.out.println("Duplicate Characters and their count: ");
    duplicateCharactersAndCount("manojpandey");
    System.out.println("--------------------");

    System.out.println("\nDuplicate Words and their count: ");
    duplicateWordsAndCount("I am a java developer and I am proud of it ");
    System.out.println("--------------------");

    System.out.println("\nSorted Employees based on salary: ");
    testEmployee().forEach(System.out::println);
    System.out.println("--------------------");

    System.out.println("\nReverse a string: ");
    reverseString("Hello World!");
    System.out.println("--------------------");

    System.out.println("\nReverse array: ");
    reverseArray(new String[]{"Hello", "World", "Java", "Developer", "2025"});
    System.out.println("--------------------");

    System.out.println("\nFibonacci Series: ");
    fibonacci(10);
    System.out.println("--------------------");

    System.out.println("\nFibonacci Series Using Recursion: " + fibonacciUsingRecursion(10));
    System.out.println("--------------------");

    System.out.println("\nFactorial: " + factorial(5));
    System.out.println("--------------------");

    System.out.println("\nFactorial using recursion: " + factorialUsingRecursion(5));
    System.out.println("--------------------");

    System.out.println("\nCheck Palindrome: " + secondLargestInArray("madam"));
    System.out.println("--------------------");

    System.out.println("\nSecond Largest in Array: " + secondLargestInArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    System.out.println("--------------------");

    System.out.println("\nRemove from List: ");
    removeFromList();
    System.out.println("--------------------");

    System.out.println("\nRemove Duplicates from List: ");
    ArrayList<String> list = new ArrayList<>(
        Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice", "Bob", "Charlie", "David"));
    removeDuplicates(list);
    System.out.println("--------------------");

    HashSet shortSet = new HashSet();

    for (short i = 0; i < 100; i++) {
      shortSet.add(i);
      shortSet.remove(i - 1);
    }
    System.out.println(shortSet.size());
  }

  static void duplicateCharactersAndCount(String str) {
    if (str == null || str.isEmpty()) {
      System.out.println("Input string is null or empty.");
      return;
    }

    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : str.toLowerCase().toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
    }
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
    }
  }

  static void duplicateWordsAndCount(String str) {
    if (str == null || str.isEmpty()) {
      System.out.println("Input string is null or empty.");
      return;
    }

    str = str.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
    HashMap<String, Integer> map = new HashMap<>();
    String[] splittedString = str.split("\\s+");
    for (String s : splittedString) {
      if (!s.isEmpty()) {
        map.put(s, map.getOrDefault(s, 0) + 1);
      }
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
    }
  }

  static List<Employee> testEmployee() {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Alice", 50000, 23, "HR"));
    employees.add(new Employee("Bob", 60000, 25, "IT"));
    employees.add(new Employee("Charlie", 40000, 27, "Finance"));
    return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName))
        .collect(Collectors.toList());
  }

  static void reverseString(String str) {
    if (str == null || str.isEmpty()) {
      System.out.println("Input string is null or empty.");
      return;
    }
    char[] charArray = str.toCharArray();
    StringBuilder reversedString = new StringBuilder();
    for (int i = charArray.length - 1; i >= 0; i--) {
      reversedString.append(charArray[i]);
    }
    System.out.println(reversedString);
  }

  static void reverseArray(String[] str) {
    if (str == null || str.length == 0) {
      System.out.println("Input array is empty.");
      return;
    }
    int left = 0;
    int right = str.length - 1;
    while (left < right) {
      String temp = str[left];
      str[left] = str[right];
      str[right] = temp;
      left++;
      right--;
    }
    System.out.println(Arrays.toString(str));
  }

  static void fibonacci(int num) {
    int first = 0;
    int second = 1;
    for (int i = 0; i < num; i++) {
      System.out.println(first);
      int temp = first + second;
      first = second;
      second = temp;
    }
  }

  static int fibonacciUsingRecursion(int num) {
    if (num <= 1) {
      return num;
    } else {
      return fibonacciUsingRecursion(num - 1) + fibonacciUsingRecursion(num - 2);
    }
  }

  static int factorial(int num) {
    if (num < 1) {
      return -1;
    }
    int fact = 1;
    while (num > 1) {
      fact *= num;
      num--;
    }
    return fact;
  }

  static int factorialUsingRecursion(int num) {
    if (num == 1) {
      return 1;
    }
    if (num < 1) {
      return -1;
    }
    int fact = 1;
    return fact * num * factorial(num - 1);
  }

  static boolean secondLargestInArray(String str) {
    if (str == null || str.isEmpty()) {
      System.out.println("Input string is null or empty.");
      return false;
    }
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  static int secondLargestInArray(int[] num) {
    int first = 0;
    int second = 0;

    for (int i = 0; i < num.length; i++) {
      if (num[i] > first) {
        second = first;
        first = num[i];
      } else if (num[i] > second && num[i] != first) {
        second = num[i];
      }
    }
    return second;
  }

  static void removeFromList() {
    List<String> list = new ArrayList<>();
    list.add("Alice");
    list.add("Bob");
    list.add("Charlie");
    list.add("David");

    if (list.contains("Alice")) {
      list.remove("Alice");
    }
    list.forEach(System.out::println);
  }

  public static void removeDuplicates(ArrayList<String> list) {
    // Create a HashSet to store unique values
    HashSet<String> uniqueValues = new HashSet<>(list);
    // Clear the original list and add the unique values back
    list.clear();
    list.addAll(uniqueValues);
    list.forEach(System.out::println);
  }
}
