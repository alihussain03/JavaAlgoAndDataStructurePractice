package Grokking.Recursion.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciSeries {

  private static Map<Integer, Integer> memoizationTable;

  public static void main(String[] args) {
    System.out.println("Calculate Fibonacci: ");
    for (int i = 0; i < 5; i++) {
      System.out.print(calculateFibonacci(i) + " ");
    }
    int n = 5;
    System.out.println("Print Fibonacci Recursively");
    printFibonacciSeries(0, 1, n - 2); // n-2 because first two are 0a nd 1

    System.out.println("\nUsing Memorization ");
    memoizationTable = new HashMap<>();
    System.out.println(getFibonacciWithMemoization(5));

    //for Grokking course exercise
    fibonacci(0);
  }

  public static int calculateFibonacci(int n) {
    if (n == 1 || n == 0) {
      return n;
    }
    return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
  }

  public static void printFibonacciSeries(int a, int b, int index) {
    System.out.print(a + " ");
    if (index < 0) {
      return;
    }
    printFibonacciSeries(b, a + b, index - 1);
  }

  public static List<Integer> fibonacci(int n) {
    List<Integer> result = new ArrayList<>();
    memoizationTable = new HashMap<>();
    for (int i = 0; i <= n; i++) {
      result.add(getFibonacciWithMemoization(i));
    }
    return result;
  }

  public static int getFibonacciWithMemoization(int n) {
    if (n == 0 || n == 1) {
      return n; // Base case: return n if n is 0 or 1
    }

    // Check if Fibonacci number is already calculated and stored in memoization table
    if (memoizationTable.containsKey(n)) {
      return memoizationTable.get(n);
    }

    // Calculate Fibonacci number using recursion
    int fib = getFibonacciWithMemoization(n - 1) + getFibonacciWithMemoization(n - 2);

    // Store Fibonacci number in memoization table for future use
    memoizationTable.put(n, fib);

    return fib;
  }
}